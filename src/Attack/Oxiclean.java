package Attack;

import Entities.Entity;
import Levels.LevelPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Oxiclean extends Attack implements Collidable{
    private LevelPanel currentPanel;
    private final double playerY;

    public Oxiclean(LevelPanel currentPanel) throws IOException {
        super("Oxiclean", 8, ImageIO.read(new File("Assets/Oxi.png")));
        this.setX(464);
        this.setY(232);
        this.currentPanel = currentPanel;
        playerY = currentPanel.getPlayer().getyPos() - this.getY();
    }

    public void draw(Graphics g) {
        this.setX(this.getX() - 1.5);
        this.setY(this.getY() + playerY/500);
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
