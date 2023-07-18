package Model;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeBody extends Node {

    public SnakeBody(int x, int y) {
        super(x, y);
    }

    @Override
    public void desenhar(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(this.getX(), this.getY(), Node.TAMANHO, Node.TAMANHO);
    }
    
}
