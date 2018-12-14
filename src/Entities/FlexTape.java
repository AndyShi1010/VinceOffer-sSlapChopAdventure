package Entities;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FlexTape extends SmallEnemy {
    public FlexTape() {
        super("FlexTape", 4);
    }

    public FlexTape(int x, int y) throws IOException {
        super("FlexTape", 4, ImageIO.read(new File("Assets/FlexTape.png")), x ,y);
    }
}
