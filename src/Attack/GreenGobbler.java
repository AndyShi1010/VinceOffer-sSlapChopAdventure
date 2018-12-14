package Attack;

import Entities.Entity;
import Levels.LevelPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GreenGobbler extends Attack implements Collidable{

    private LevelPanel currentPanel;

    public GreenGobbler(LevelPanel currentPanel, double y) throws IOException {
        super("Green Gobbler", 3, ImageIO.read(new File("Assets/Green.png")));
        this.setY(y);
        this.setX(464);
        this.currentPanel = currentPanel;
    }

    public void draw(Graphics g) {

        this.setX(this.getX() - 1);
        g.drawImage(this.getSprite(), (int)this.getX() + this.getSprite().getWidth(null), (int)this.getY(), null);
        this.setHitBox(new Rectangle((int)this.getX() + this.getSprite().getWidth(null), (int)this.getY(), this.getSprite().getWidth(null), this.getSprite().getHeight(null)));
        if (this.checkCollision(currentPanel.getPlayer())) {
            currentPanel.getPlayer().setHealth(currentPanel.getPlayer().getHealth() - this.getDamage());
            this.setDamage(0);
        }
    }

    @Override
    public boolean checkCollision(Entity object) {
        return (this.getHitBox().intersects(object.getHitBox()));
    }

}
