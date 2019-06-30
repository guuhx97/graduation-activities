/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package evacuation;

import java.util.Random;

/**
 *
 * @author arthur
 */
public class NatureFactory {
    public static Nature getNature()
    {
        Random random = new Random();
        
        if(random.nextBoolean())
        {
            return Nature.AGGRESSIVE;
        }
        else
        {
            return Nature.PASSIVE;
        }
    }
}
