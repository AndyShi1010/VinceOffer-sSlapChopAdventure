package MainGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TitlePanel extends JPanel {
    private IconButton play, about, exit;

    public TitlePanel(JFrame currentFrame) {
        setLayout(null);
        setBackground(new Color(0, 0, 0, 0));
        try {
            play = new PlayButton(320, 380, this, currentFrame);
            about = new InfoButton(180, 380, this);
            exit = new CloseProgramButton(460, 380, this, currentFrame);
            add(play);
            add(about);
            add(exit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        //System.out.print("Paint Title Panel");
        try {
            g.drawImage(ImageIO.read(new File("Assets/Orange.png")), 0 ,0, null);
            g.drawImage(ImageIO.read(new File("Assets/Title.png")), 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.paint(g);
    }
}
