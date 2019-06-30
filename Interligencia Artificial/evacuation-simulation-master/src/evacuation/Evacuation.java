/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package evacuation;
import jade.core.Profile;
import jade.core.ProfileImpl;
//import jade.core.Profile;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jade.core.Runtime;
//import java.util.Properties;
/*import jade.core.Profile;

import jade.core.ProfileImpl;

import jade.core.Runtime;

import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;
*/
/**
 *
 * @author arthur
 */
public class Evacuation {
    
    public static Room ROOM;
    /**
     * @param args the command line arguments
     */
    
    public Evacuation(String[] args) {
        Integer numberOfAgents = new Integer(args[0]);
        Integer lines = new Integer(args[1]);
        Integer columns = new Integer(args[2]);
        
        System.out.println("linhas: " + lines + " colunas: " + columns + " numberOfAgents: " + numberOfAgents);
        
        ROOM = new Room(lines, columns, numberOfAgents.intValue());
        
        System.out.println(ROOM == null ? "null" : "not null");
        
        Runtime rt = Runtime.instance();
        
        rt.setCloseVM(true);

        Profile p = new ProfileImpl();
        
        p.setParameter(Profile.MAIN_HOST, "127.0.0.1");
        
        p.setParameter(Profile.MAIN_PORT, "1199");
        
        AgentContainer ac = rt.createMainContainer(p);
        
        Object[] o = new Object[1];
        
        for(int i = 0; i < numberOfAgents; i++)
        {
            AgentController agent = null;
            try {
                agent = ac.createNewAgent (String.valueOf(i), "evacuation.Person", null);
            } catch (StaleProxyException ex) {
                Logger.getLogger(Evacuation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                agent.start();
            } catch (StaleProxyException ex) {
                Logger.getLogger(Evacuation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            AgentController rma = ac.createNewAgent("rma", "jade.tools.rma.rma", null);            
            rma.start();            
        } catch(StaleProxyException e) {
            e.printStackTrace();
        }        
    }
    
    /*public static void main(String[] args) {
        Integer numberOfAgents = new Integer(args[0]);
        Integer lines = new Integer(args[1]);
        Integer columns = new Integer(args[2]);
        
        System.out.println("linhas: " + lines + " colunas: " + columns + " numberOfAgents: " + numberOfAgents);
        
        ROOM = new Room(lines, columns, numberOfAgents.intValue());      
        
        Runtime rt = Runtime.instance();
        
        rt.setCloseVM(true);

        Profile p = new ProfileImpl();
        
        p.setParameter(Profile.MAIN_HOST, "127.0.0.1");
        
        p.setParameter(Profile.MAIN_PORT, "1199");
        
        AgentContainer ac = rt.createMainContainer(p);
        
        Object[] o = new Object[1];
        
        for(int i = 0; i < numberOfAgents; i++)
        {
            AgentController agent = null;
            try {
                agent = ac.createNewAgent (String.valueOf(i), "evacuation.Person", null);
            } catch (StaleProxyException ex) {
                Logger.getLogger(Evacuation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                agent.start();
            } catch (StaleProxyException ex) {
                Logger.getLogger(Evacuation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            AgentController rma = ac.createNewAgent("rma", "jade.tools.rma.rma", null);
            rma.start();
        } catch(StaleProxyException e) {
            e.printStackTrace();
        }
        
    }*/
}