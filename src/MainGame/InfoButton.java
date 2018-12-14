package MainGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class InfoButton extends IconButton implements MouseListener{


    public InfoButton(int x, int y, JPanel currentPanel) throws IOException {
        super("Info", ImageIO.read(new File("Assets/info.png")), x, y, currentPanel);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        AboutWindow infoWindow = new AboutWindow();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

//    @Override
//    public void mouseEntered(MouseEvent e) {
//        try {
//            super.hoverImage(ImageIO.read(new File("Assets/info.png")));
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//    }

    @Override
    public void mouseExited(MouseEvent e) {
        try {
            this.icon = ImageIO.read(new File("Assets/info.png"));
            this.currentPanel.repaint();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
