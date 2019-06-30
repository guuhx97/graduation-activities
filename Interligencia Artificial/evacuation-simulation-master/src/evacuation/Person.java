/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package evacuation;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.awt.Point;
import java.sql.Time;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arthur
 */
public class Person extends Agent {
    
    public static String PUSH = "PUSH";
    
    private Nature nature;
    private Point position;
    private boolean standing;
    private boolean safe;
    private int pushedTimes;
    private int PUSH_LIMIT;
    private int rounds;
    Point destination;
    AgentNotification notification;
    
    public void setNotification(AgentNotification notification)
    {
        this.notification = notification;
    }
    
    @Override
    protected void setup()
    {
        standing = true;
        safe = false;
        pushedTimes = 0;
        PUSH_LIMIT = 2;
        rounds = 0;
        
        nature = NatureFactory.getNature();
        
        register();
        
        destination = Evacuation.ROOM.getExit();
        
        addAction(Action.HANDLE_RECEIVED_MESSAGES);
        
        addAction(Action.RUN);
        
        //TODO tem que pensar numa barreira pra ações criadas
    }
    
    private void push(AID aid)
    {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.addReceiver(aid);
        //System.out.println("pushing: " + aid.getName());
        message.setContent(PUSH);
        send(message);
    }
    
    public void setPosition(Point p)
    {
        this.position = p;
    }
    
    public void setSafe(boolean safe)
    {
        this.safe = safe;
    }
    
    public boolean isSafe()
    {
        return safe;
    }
    
    public boolean isStanding()
    {
        return standing;
    }
    
    public Point getPosition()
    {
        return this.position;
    }
    
    public boolean shouldPush()
    {
        Random r = new Random();
        
        float probability = r.nextFloat();
        
        return getNature() == Nature.AGGRESSIVE ? probability > .2 : probability < .2;
    }
    
    private Square getNextSquare()
    {
        Point next = dijkstra().pop();
        
        Evacuation.ROOM.waitEveryoneCalculateRoute();
        
        //System.out.println("i'm: x: " + position.x + " y: " + position.y);
        //System.out.println("next square x: " + next.x + " y: " + next.y);
        return Evacuation.ROOM.getSquare(next);
    }
    
    private void setStanding(boolean standing)
    {
        this.standing = standing;
        if(this.standing == false)
        {
            notification.notifyParent(Event.AGENT_DIED);
        }
    }
    
    private void handleRound()
    {
        rounds++;
        
        if(rounds % 5 == 0)
        {
            pushedTimes--;
        }
        
    }
    
    private void addAction(Action action)
    {
        switch(action)
        {
            case HANDLE_RECEIVED_MESSAGES:
            {
                /*
                Ação para tratar mensagens recebidas
                */
                addBehaviour(new CyclicBehaviour(this) {
                    @Override
                    public void action() {
                        ACLMessage message = myAgent.receive();
                        Person self = (Person)myAgent;
                //                        Evacuation.ROOM.getLock().lock();
                        if(message != null)
                        {
                            if(message.getContent().equalsIgnoreCase(PUSH))
                            {
                                Evacuation.ROOM.getLock().lock();
                                System.out.println(self.getLocalName() + " pushed by: " + message.getSender().getLocalName());
                                pushedTimes++;

                                if(pushedTimes > PUSH_LIMIT)
                                {
                                    
                                    self.setStanding(false);

                                    //Simulation.renderUnique(Evacuation.ROOM.getSquare(position));

                                    Simulation.queueDynamicChange(Evacuation.ROOM.getSquare(position));
                                    
//                                    notification.notifyParent(Event.STATE_CHANGED);

                                    //Evacuation.ROOM.getLock().unlock();
                                    System.out.println(self.getLocalName() + " is now dead");
                                }
                                Evacuation.ROOM.getLock().unlock();
                            }

                        }
                        else
                        {
                        //                            Evacuation.ROOM.getLock().unlock();
                            block();
                        }

                    }
                });
                break;
            }
            case RUN:
            {
                //TODO mudar para cyclic behaviour
                addBehaviour(new Behaviour(this) {
                    @Override
                    public void action() {
                        Person self = (Person)myAgent;
                        Square next = getNextSquare();
                        Evacuation.ROOM.getLock().lock();
                        
                        //TODO only for debugging
                        //Evacuation.ROOM.draw(rounds);
                        try
                        {
                            ObjectType type = next.getType();
                            
                            if(ObjectType.PERSON.equals(type))
                            {
                                Agent agent = next.getAgent();
                                
                                if(self.shouldPush())
                                {
                                    self.push(agent.getAID());
//                                    System.out.println(self.getLocalName() + " pushing " + aid.getLocalName());
                                }
                            }
                            else if(!(ObjectType.OBSTACLE.equals(type) || ObjectType.FIRE.equals(type)))
                            {
                                Evacuation.ROOM.moveFromTo(Evacuation.ROOM.getSquare(position), next);
                                
                                self.setPosition(next.getPosition());
                                
                                if(Evacuation.ROOM.getExit().equals(self.getPosition()))
                                {
                                    //System.out.println(self.getLocalName() + " is safe now!");
                                    self.setSafe(true);
                                }
                            }
                        }
                        finally
                        {
                            
                            try {
                                TimeUnit.MILLISECONDS.sleep(20);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //DELAY DE 20ms AQUI
                            Evacuation.ROOM.getLock().unlock();
                            block(1000);
                        }
                    }
                    
                    @Override
                    public boolean done() {
                        Person self = (Person)myAgent;
                        self.handleRound();
                        return !self.isStanding() || self.isSafe();
                    }
                });
                break;
            }
        }
    }
    
    private void register()
    {
//        Evacuation.ROOM.getLock().lock();
        this.position = Evacuation.ROOM.register(this);
        
        Evacuation.ROOM.waitEveryoneRegister();
        
    }
    
    /*
    1) Initialize distances of all vertices as infinite.
    
    2) Create an empty priority_queue pq.  Every item
    of pq is a pair (weight, vertex). Weight (or
    distance) is used used as first item  of pair
    as first item is by default used to compare
    two pairs
    
    3) Insert source vertex into pq and make its
    distance as 0.
    
    4) While either pq doesn't become empty
    a) Extract minimum distance vertex from pq.
    Let the extracted vertex be u.
    b) Loop through all adjacent of u and do
    following for every vertex v.
    
    // If there is a shorter path to v
    // through u.
    If dist[v] > dist[u] + weight(u, v)
    
    (i) Update distance of v, i.e., do
    dist[v] = dist[u] + weight(u, v)
    (ii) Insert v into the pq (Even if v is
    already there)
    
    5) Print distance array dist[] to print all shortest
    paths.
    */
    
    private Stack<Point> dijkstra()
    {
        int lines = Evacuation.ROOM.getLines();
        int columns = Evacuation.ROOM.getColumns();
        // begin step 1
        DijkstraNode[][] matrix = new DijkstraNode[lines][columns];
        
        for(int i = 0; i < lines; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                matrix[i][j] = new DijkstraNode(new Point(i, j), Integer.MAX_VALUE);
            }
        }
        // end step 1
        
        // begin step 2
        PriorityQueue<DijkstraNode> pq = new PriorityQueue<>(lines * columns);
        // begin step 2
        
        // begin step 3
        matrix[position.x][position.y].distance = 0;
        matrix[position.x][position.y].previous = null;
        
        pq.add(matrix[position.x][position.y]);
        // end step 3
        
        //System.out.println("destination: "+ destination);
        //System.out.println("me: " + position);
        
        // begin step 4
        while(!pq.isEmpty())
        {
            // begin step 4)A)
            DijkstraNode u = pq.poll();
            // end step 4)A)
            
            if(u.position.equals(destination))
            {
                //System.out.println("found my destination");
                break;
            }
            
            int uDist = matrix[u.position.x][u.position.y].distance;
            
            // begin step 4)B)
            ArrayList<Square> adjs = Evacuation.ROOM.getSquare(u.position).getAdjacents();
            
            adjs.forEach((adj) -> {
                Point adjPos = adj.getPosition();
                
                int vDist = matrix[(int)adjPos.getX()][(int)adjPos.getY()].distance;
                int weightUV = Evacuation.ROOM.getSquare(adjPos).getDistance();
                
                if(vDist > uDist + weightUV)
                {
                    matrix[(int)adjPos.getX()][(int)adjPos.getY()].distance = uDist + weightUV;
                    pq.add(matrix[(int)adjPos.getX()][(int)adjPos.getY()]);
                    matrix[(int)adjPos.getX()][(int)adjPos.getY()].previous = u;
                }
                
            }); // end step 4)B)
            
        }
        
        /*Evacuation.ROOM.getLock().lock();
        System.out.println("eu sou o x: " + position.x + " y: " + position.y);
        System.out.println("pessoas");
        for (Square[] s : Evacuation.ROOM.squares()) {
        for (Square square : s) {
        System.out.print(square.getDistance() + "\t");
        }
        System.out.print("\n");
        }
        
        System.out.println("distancia");
        for (T[] ts : matrix) {
        for (T t : ts) {
        System.out.print(t.distance + "\t");
        }
        System.out.print("\n");
        }
        
        System.out.println("caminho: ");*/
        DijkstraNode nav = matrix[(int)destination.x][(int)destination.y];
        
        Stack<Point> stack = new Stack<>();
        
        do
        {
//            System.out.print("x: " + nav.position.x + " y: " + nav.position.y + "-> ");
            //System.out.println("nav: " + nav.position);
            stack.add(nav.position);
            
            nav = nav.previous;
        }while(nav.previous != null);
        //System.out.println("");
        //Evacuation.ROOM.getLock().unlock();
        return stack;
    }
    
    public Nature getNature() {
        return nature;
    }
}
