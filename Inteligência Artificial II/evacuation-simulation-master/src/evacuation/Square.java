/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package evacuation;

import jade.core.AID;
import jade.core.Agent;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author arthur
 */
public class Square implements AgentNotification{
    
    /*    public Square()
    {
    adjacents = new ArrayList();
    }
    */
    public Square(Point point, ObjectType type)
    {
        adjacents = new ArrayList();
        position = point;
        deadPeople = new ArrayList();
        this.type = type;
        sprite = new Sprite();
    }
    
    private final Point position;
    private ObjectType type;
    private Agent agent;
    private final ArrayList<Square> adjacents;
    private ArrayList<Agent> deadPeople;
    private Sprite sprite;
    
    public Sprite getSprite() {
        return sprite;
    }
    
    public Point getPosition()
    {
        return position;
    }
    
    public void addAdj(Square square)
    {
        adjacents.add(square);
    }
    
    public ArrayList<Square> getAdjacents() {
        return adjacents;
    }
    
    public void setAgent(Agent newAgent)
    {
        agent = newAgent;
        // caso eu estou removendo o agente daqui,
        // preciso verificar se havia alguém morto
        if(agent == null && !ObjectType.EXIT.equals(getType()))
        {
            if(deadPeople.size() > 0)
            {
                setType(ObjectType.DEAD_PERSON);
            }
            else
            {
                setType(ObjectType.EMTPY);
            }
        }
        else
        {
            if(ObjectType.EMTPY.equals(getType()))// || ObjectType.EXIT.equals(next.getType()))
            {
                setType(ObjectType.PERSON);
                
                Person p = (Person)agent;
                p.setNotification(this);
            }
                    
            
        }
    }
    
    public Agent getAgent()
    {
        return agent;
    }
    
    public void setType(ObjectType type)
    {
        try {
            if (null != type) switch (type) {
                case PERSON:
                    sprite.setImage(getClass().getResource("/rsc/Standing_up_active.png").toString());
                    break;
                case EXIT:
                    sprite.setImage(getClass().getResource("/rsc/door.png").toString());
                    break;
                case FIRE:
                    sprite.setImage(getClass().getResource("/rsc/fire.png").toString());
                    break;
                case DEAD_PERSON:
                    sprite.setImage(getClass().getResource("/rsc/Standing_up_died.png").toString());
                    break;
                default:
                    break;
            }
            sprite.setPosition((position.x*sprite.getBoundary().getWidth()), (position.y*sprite.getBoundary().getHeight()));
        } catch (Exception ex){
            System.out.println("deu ruimmmmmmmm");
        }
        
        this.type = type;
    }
    
    public ObjectType getType()
    {
        return type;
    }
    
    public int getDistance()
    {
        /*if(agent == null) return 1;
        else return 2;*/
        switch(type)
        {
            case EXIT:
                return 1;
            case PERSON:
                return 4;
            case DEAD_PERSON:
                return 2;
            case FIRE:
                return 999;
            case OBSTACLE:
                return 4;
            case EMTPY:
                return 1;
            default:
                return 999;
        }
    }
    
    public boolean hasDeadPeople()
    {
        return deadPeople.size() > 0;
    }
    
    @Override
    public void notifyParent(Event type) {
        if(Event.AGENT_DIED.equals(type))
        {
            deadPeople.add(agent);
            setAgent(null);
        }
    }
}
