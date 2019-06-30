/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package evacuation;
import jade.core.AID;
import jade.core.Agent;
import java.awt.Point;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author arthur
 */
public final class Room{
    public Room(int lines, int columns, int numberOfAgents)
    {
        
        this.lines = lines;
        this.columns = columns;
        this.maxNumberOfAgents = numberOfAgents;
        roundCount = 0;
        
        initSquares();
        
        mutex = new ReentrantLock(true);
        registerBarrier = new CountDownLatch(numberOfAgents);
        routeBarrier = new CountDownLatch(numberOfAgents);
    }
    
    private final int lines;
    private final int columns;
    private final int maxNumberOfAgents;
    private Point exit;
    private Square[][] squares;
    private int numberOfRegisteredAgents;
    private int peopleWithRouteCounter;
    private final ReentrantLock mutex;
    private final CountDownLatch registerBarrier;
    private final CountDownLatch routeBarrier;
    private int roundCount;
    
    public Point register(Person agent)
    {
        mutex.lock();
        Point point = getRandomPoint();
        
        //TODO tem que arrumar esse fuckin -2 aqui.
        if(numberOfRegisteredAgents > lines * columns - 2)
        {
            for(;;)
            {
                System.out.println("deu pau aqui deu pau aqui");
            }
        }
        
        numberOfRegisteredAgents++;
        
        while(!squares[(int)point.getX()][(int)point.getY()].getType().equals(ObjectType.EMTPY))
        {
            point = getRandomPoint();
        }
        
        squares[(int)point.getX()][(int)point.getY()].setAgent(agent);
        squares[(int)point.getX()][(int)point.getY()].setType(ObjectType.PERSON);
        
//        Simulation.renderUnique(squares[(int)point.getX()][(int)point.getY()]);
        Simulation.queueStaticChange(squares[(int)point.getX()][(int)point.getY()]);
        
        mutex.unlock();
        return point;
    }
    
    public int getLines() {
        return lines;
    }
    
    public int getColumns() {
        return columns;
    }
    
    //TODO temp
    public Square[][] squares()
    {
        return squares;
    }
    
    public Square getSquare(Point p)
    {
        //TODO isso pode ser um grande problema.
        if(!isPointValid(p)) return null;
        
        // é a saída, então posso o camarada chegou no pote de ouro
        //if(exit == p) return null;
        
        // estou assumindo que squares[y][x] não é nulo
        return squares[(int)p.getX()][(int)p.getY()];
    }
    
    private boolean isPointValid(Point p)
    {
        return p.getX() < this.columns && p.getY() < this.lines;
    }
    
    public void draw(int round)
    {
       /* try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       /* if(round <= roundCount)
        {
            return;
        }*/
        
        String output = new String();
        
        roundCount = round;
        
        /*try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        System.out.print("\033[H\033[2J");  
        System.out.flush();
//        System.out.println("-----------------------------");
        
        for (Square[] square : squares) {
            for (Square square1 : square) {
                switch (square1.getType()) {
                    case EMTPY:
                        output += "0\t";
//                        System.out.print("0\t");
                        break;
                    case FIRE:
                        output += square1.getType() + "\t";
//                        System.out.print(square1.getType() + "\t");
                        break;
                    case EXIT:
                        output += square1.getType() + "\t";
//                        System.out.print(square1.getType() + "\t");
                        break;
                    case PERSON:
                        output += square1.getAgent().getLocalName() + "\t";
//                        System.out.print(square1.getAgent().getLocalName() + "\t");
                        break;
                    case DEAD_PERSON:
                        output += "D\t";
//                        System.out.print("D\t");
                        break;
                    default:
                        output += square1.getType() + "\t";
//                        System.out.print(square1.getType() + "\t");
                        break;
                }
                
            }
            output += "\n";
//            System.out.println();
        }
    }
    
    public void moveFromTo(Square previous, Square next)
    {
//        squares[(int)next.getPosition().getX()][(int)next.getPosition().getY()].setAgent(previous.getAgent());
//        squares[(int)previous.getPosition().getX()][(int)previous.getPosition().getY()].setAgent(null);
        
        next.setAgent(previous.getAgent());
        previous.setAgent(null);
        
        /*if(ObjectType.EMTPY.equals(next.getType()))// || ObjectType.EXIT.equals(next.getType()))
        {
            next.setType(previous.getType());
        }*/
        
        //previous.setType(ObjectType.EMTPY);
        
        Simulation.queueDynamicChange(next);
        Simulation.queueDynamicChange(previous);
    }
    
    public Point getExit()
    {
        return exit;
    }
    
    private Point getRandomPoint()
    {
        Random random = new Random();
        
        return new Point(random.nextInt(this.columns), random.nextInt(this.lines));
    }
    
    public ReentrantLock getLock()
    {
        return mutex;
    }
    
    public void waitEveryoneRegister()
    {
        registerBarrier.countDown();
        try {
            registerBarrier.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void waitEveryoneCalculateRoute()
    {
        routeBarrier.countDown();
        try {
            routeBarrier.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initSquares()
    {
        squares = new Square[lines][columns];
        
        // instancio todos os quadrados da matriz.
        for(int i = 0; i < lines; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                squares[i][j] = new Square(new Point(i, j), ObjectType.EMTPY);
            }
        }
        
        // faço com que cada quadrado adicione os seus adjacentes em uma lista.
        for(int i = 0; i < lines; i++)
        {
            boolean lookBelow = i < lines - 1;
            for(int j = 0; j < columns; j++)
            {
                boolean lookLeft = j > 0;
                boolean lookRight = j < columns - 1;
                
                int limit = i;
                
                if(lookBelow)
                {
                    limit += 1;
                    squares[i][j].addAdj(squares[i+1][j]);
                    squares[i+1][j].addAdj(squares[i][j]);
                }
                
                for(int z = i; z <= limit; z++)
                {
                    if(lookLeft && z != i)
                    {
                        squares[i][j].addAdj(squares[z][j - 1]);
                        squares[z][j - 1].addAdj(squares[i][j]);
                    }
                    
                    if(lookRight)
                    {
                        squares[i][j].addAdj(squares[z][j + 1]);
                        squares[z][j + 1].addAdj(squares[i][j]);
                    }
                }
            }
        }
        
      
        Point fire = getRandomPoint();
        
        
        
        squares[fire.x][fire.y].setType(ObjectType.FIRE);
        
        Simulation.queueStaticChange(squares[fire.x][fire.y]);
        
        System.out.println("do i get here without a problem");
        
        squares[fire.x][fire.y].getAdjacents().forEach((square) -> {
            square.setType(ObjectType.FIRE);
            Simulation.queueStaticChange(square);
        });
        
        //TODO a saída tem que ser na parede né..
        exit = getRandomPoint();
        
        while(squares[exit.x][exit.y].getType().equals(ObjectType.FIRE))
        {
            exit = getRandomPoint();
        }
        
        squares[exit.x][exit.y].setType(ObjectType.EXIT);
        
        Simulation.queueStaticChange(squares[exit.x][exit.y]);
        
        //Simulation.render(squares);
    }

}
