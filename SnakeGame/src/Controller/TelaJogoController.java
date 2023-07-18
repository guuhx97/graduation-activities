package Controller;

import Model.Node;
import Model.Snake;
import View.TelaJogo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaJogoController implements KeyListener, Runnable {

    private TelaJogo tela;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean pause;
    private Thread loop;
    private int velocidade;

    public TelaJogoController(TelaJogo tela) {
        this.tela = tela;
        up = false;
        down = false;
        left = false;
        right = true;
        pause = true;
        velocidade = 250;
        loop = new Thread(this);
    }

    public void inicializar() {
        this.tela.gamePanel.getSnake().getSnake().get(0).mover(10 * 20, 5 * 20);
        pause = false;
        this.tela.gamePanel.getTimer().start();
        loop.start();
    }

    public void reiniciar() {
        this.tela.gamePanel.getSnake().getSnake().get(0).mover(10 * 20, 5 * 20);
        pause = false;
        this.tela.gamePanel.getTimer().start();
        up = false;
        down = false;
        left = false;
        right = true;
        loop = new Thread(this);
        loop.start();
    }

    public void VerificarColisao(Node a) {
        if (a.getX() == 0 || a.getX() == (20 * 31) || a.getY() == 0 || a.getY() == (20 * 23)) {
            pause = true;
            loop.interrupt();
        }
    }

    public void VerificarColisaoComida(Node a, Node b) {
        if (a.getX() == b.getX() && a.getY() == b.getY()) {
            this.tela.gamePanel.getSnake().crescerSnake();
            int x = (new Random().nextInt(30) + 1);
            int y = (new Random().nextInt(22) + 1);
            this.tela.gamePanel.getFruta().mover(x * 20, y * 20);
            this.velocidade -= 20;
        }
    }

    public void VerificarColisaoCobrinha(Snake a) {
        ArrayList<Node> b = a.getSnake();
        for (int i = 1; i < a.getSnake().size() - 1; i++) {
            if (b.get(0).getX() == b.get(i).getX() && b.get(0).getY() == b.get(i).getY()) {
                pause = true;
                loop.interrupt();
            }
        }
    }

    private void atualizar() {
        if (up) {
            this.tela.gamePanel.getSnake().atualizar(Snake.UP);
        } else if (down) {
            this.tela.gamePanel.getSnake().atualizar(Snake.DOWN);
        } else if (left) {
            this.tela.gamePanel.getSnake().atualizar(Snake.LEFT);
        } else if (right) {
            this.tela.gamePanel.getSnake().atualizar(Snake.RIGHT);
        }
    }

    @Override
    public void run() {
        while (pause == false) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(TelaJogoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.atualizar();
            this.VerificarColisao(this.tela.gamePanel.getSnake().getSnake().get(0));
            this.VerificarColisaoComida(this.tela.gamePanel.getSnake().getSnake().get(0), this.tela.gamePanel.getFruta());
            this.VerificarColisaoCobrinha(this.tela.gamePanel.getSnake());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && this.down == false) {
            this.up = true;
            this.left = false;
            this.right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && this.up == false) {
            this.down = true;
            this.left = false;
            this.right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && this.right == false) {
            this.down = false;
            this.left = true;
            this.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && this.left == false) {
            this.down = false;
            this.right = true;
            this.up = false;
        }else if (e.getKeyCode() == KeyEvent.VK_R && this.pause == true) {
            this.reiniciar();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
