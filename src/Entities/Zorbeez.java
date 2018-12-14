package Entities;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Zorbeez extends SmallEnemy {
    public Zorbeez(){
        super("Zorbeez", 6);
    }
    public Zorbeez(int x, int y) throws IOException {
        super("Zorbeez", 6, ImageIO.read(new File("Assets/Zorbeez.png")), x ,y);
    }
}
