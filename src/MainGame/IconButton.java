package MainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class IconButton extends JComponent implements MouseListener{
    String name;
    Image icon;
    int xPos;
    int yPos;
    JPanel currentPanel;

    public IconButton(String name, Image icon, int xPos, int yPos, JPanel panel) {
        this.name = name;
        this.icon = icon;
        this.xPos = xPos;
        this.yPos = yPos;
        this.currentPanel = panel;
        super.addMouseListener(this);
        super.setLocation(this.xPos - (this.icon.getWidth(null)/2), this.yPos - this.icon.getHeight(null)/2);
        super.setSize(icon.getWidth(null), icon.getHeight(null));
        super.setVisible(true);
    }

    @Override
    public void paint (Graphics g) {
        g.drawImage(this.icon, 0, 0, null);
    }

    public void hoverImage(Image icon) {
       this.icon = ImageUtilities.darkenImage(icon, 0.25f);
       this.currentPanel.repaint();
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hoverImage(this.icon);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

