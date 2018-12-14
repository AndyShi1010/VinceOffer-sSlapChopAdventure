package MainGame;

import Entities.*;
import Levels.LevelOnePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class PlayButton extends IconButton {

    private JFrame currentFrame;

    public PlayButton(int x, int y, JPanel currentPanel, JFrame currentFrame) throws IOException{
        super("Info", ImageIO.read(new File("Assets/play.png")), x, y, currentPanel);
        this.currentFrame = currentFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            LevelOnePanel levelOne = new LevelOnePanel((GameFrame)currentFrame);
            currentFrame.setContentPane(levelOne);
            levelOne.repaint();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        currentFrame.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        try {
            this.icon = ImageIO.read(new File("Assets/play.png"));
            this.currentPanel.repaint();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
