/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evacuation;

/**
 *
 * @author arthur
 */
public class Path {
    public int distance;
    public int previous;
    public boolean open;
    
    public Path(int distance, int previous)
    {
        this.distance = distance;
        this.previous = previous;
    }
    
    public Path()
    {
        distance = -1;
        previous = -1;
        open = true;
    }
}
