package Entities;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MightyThirsty extends SmallEnemy {

    public MightyThirsty(){
        super("Mighty Thirsty", 2);
    }

    public MightyThirsty(int x, int y) throws IOException {
        super("Mighty Thirsty", 2, ImageIO.read(new File("Assets/MightyThirsty.png")), x ,y);
    }
}
