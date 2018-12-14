package Attack;

import Entities.Entity;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Salad extends Attack {

    private final int rechargeTime = 20;

    public Salad(String name, int damage) throws IOException {
        super("Salad", 15, ImageIO.read(new File("/Assets/close.png"))); //x3 effective power = 45 damage
    }

//    @Override
//    public void doAttack(Entity enemy) {
//
//    }
}
