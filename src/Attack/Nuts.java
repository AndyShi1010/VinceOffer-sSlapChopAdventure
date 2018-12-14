package Attack;

import Entities.Entity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Nuts extends Attack {

    private final int rechargeTime = 10;

    public Nuts(String name, int damage) throws IOException {
        super("Nuts", 10, ImageIO.read(new File("/Assets/close.png"))); // x4 effective power = 40 damage
    }

}
