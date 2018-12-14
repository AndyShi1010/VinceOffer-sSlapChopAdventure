package MainGame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GamePanel levelOnePanel, levelTwoPanel, levelThreePanel;
    private TitlePanel mainPanel;
    private final double screenWidth, screenHeight;

    public GameFrame() {
        super("Vince's Slap Chop Adventure");
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        this.setLocation((int)(screenWidth/2) - 320, (int)(screenHeight/2) - 240);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new TitlePanel(this);
        this.setContentPane(mainPanel);
        mainPanel.repaint();
        repaint();
        this.setSize(656, 519);
    }

    public void refreshFrame() {
        //idk why setSize forces a repaint. This is my workaround cause repaint sometimes doesn't work.
        this.setSize(655, 519);
        this.setSize(656, 519);
    }

}
