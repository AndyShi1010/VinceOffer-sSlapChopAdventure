package MainGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class CloseProgramButton extends IconButton{
    private JFrame currentFrame;

    public CloseProgramButton(int x, int y, JPanel currentPanel, JFrame currentFrame) throws IOException{
        super("Info", ImageIO.read(new File("Assets/close.png")), x, y, currentPanel);
        this.currentFrame = currentFrame;
    }

    public CloseProgramButton(JPanel currentPanel, JFrame currentFrame) throws IOException{
        super("Info", ImageIO.read(new File("Assets/close.png")), 0, 0, currentPanel);
        this.currentFrame = currentFrame;
    }

    public void mouseClicked (MouseEvent e) {
        System.exit(0);
    }

//    @Override
//    public void mouseEntered(MouseEvent e) {
//        try {
//            super.hoverImage(ImageIO.read(new File("Assets/close.png")));
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        currentPanel.repaint();
//    }

    @Override
    public void mouseExited(MouseEvent e) {
        try {
            this.icon = ImageIO.read(new File("Assets/close.png"));
            this.currentPanel.repaint();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
