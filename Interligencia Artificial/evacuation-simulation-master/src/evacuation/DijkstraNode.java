/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evacuation;

import java.awt.Point;

/**
 *
 * @author arthur
 */
public class DijkstraNode implements Comparable<Object>{
    
    public DijkstraNode(Point point, int dist)
    {
        distance = dist;
        position = point;
        previous = null;
    }
    
    public int distance;
    public Point position;
    public DijkstraNode previous;

    @Override
    public int compareTo(Object o) {
        DijkstraNode other = (DijkstraNode)o;
        return Integer.compare(distance, other.distance);
    }
}
