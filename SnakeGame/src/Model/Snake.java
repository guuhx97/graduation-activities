package Model;

import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {

    private ArrayList<Node> snake;
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;

    public Snake(int x, int y) {
        snake = new ArrayList<>();
        SnakeBody cabeca = new SnakeBody(x, y);
        SnakeBody corpo = new SnakeBody(x, y);
        SnakeBody rabo = new SnakeBody(x, y);
        snake.add(cabeca);
        snake.add(corpo);
        snake.add(rabo);
    }

    public void crescerSnake() {
        SnakeBody newBody = (SnakeBody) this.snake.get(this.snake.size() - 1);
        this.snake.add(new SnakeBody(newBody.getX(), newBody.getY()));
    }

    public void desenhar(Graphics g) {
        for (int i = 0; i < this.snake.size(); i++) {
            this.snake.get(i).desenhar(g);
        }
    }

    public void atualizar(int direcao) {
        
        for(int i = this.snake.size() - 1; i > 0; i--){
            this.snake.get(i).mover(this.snake.get(i - 1).getX(), this.snake.get(i-1).getY());
        }
        
        switch(direcao){
            case UP:
                this.snake.get(0).setY(this.snake.get(0).getY() - Node.TAMANHO);
                break;
            case DOWN:
                this.snake.get(0).setY(this.snake.get(0).getY() + Node.TAMANHO);
                break;
            case LEFT: 
                this.snake.get(0).setX(this.snake.get(0).getX() - Node.TAMANHO);
                break;
            case RIGHT:
                this.snake.get(0).setX(this.snake.get(0).getX() + Node.TAMANHO);
                break;
        }
    }

    public ArrayList<Node> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<Node> snake) {
        this.snake = snake;
    }

}
