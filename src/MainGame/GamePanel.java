package MainGame;


import javax.swing.*;
import java.awt.*;

public abstract class GamePanel extends JPanel {
    private Image background;

    public GamePanel(Image background) {
        this.background = background;
    }
}
