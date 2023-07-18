package View;

import Model.Fruta;
import Model.Snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

    public GamePanel() {
        this.snake = new Snake(10 * 20, 5 * 20);
        int x = new Random().nextInt(31);
        int y = new Random().nextInt(23);
        this.fruta = new Fruta(x * 20, y * 20);
        this.FPS = 1000 / 300;
        this.timer = new Timer(this.FPS, this);
    }

    private Snake snake;
    private Fruta fruta;
    private final int FPS;
    private final Timer timer;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(1, 1, 640, 480);
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 640, 480);
        getSnake().desenhar(g);
        getFruta().desenhar(g);

    }

    public Fruta getFruta() {
        return fruta;
    }

    public void setFruta(Fruta fruta) {
        this.fruta = fruta;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public Timer getTimer() {
        return timer;
    }

}
