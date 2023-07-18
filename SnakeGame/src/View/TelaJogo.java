package View;

import Controller.TelaJogoController;

public class TelaJogo extends TelaBase{

    public GamePanel gamePanel;
    private TelaJogoController controle;
    
    public TelaJogo() {
        super("Tela Jogo");
        this.gamePanel = new GamePanel();
        this.gamePanel.setBounds(0,0,640,480);
        add(this.gamePanel);
        controle = new TelaJogoController(this);
        addKeyListener(controle);
        controle.inicializar();            
    }
}
