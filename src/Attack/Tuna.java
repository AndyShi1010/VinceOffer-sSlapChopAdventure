package Attack;

import Entities.Entity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Tuna extends Attack{

    private final int rechargeTime = 30;

    public Tuna() throws IOException {
        super("Tuna", 75, ImageIO.read(new File("/Assets/close.png")));
    }

//    @Override
//    public void doAttack(Entity enemy) {
//
//    }
}
