package Attack;

import Entities.Entity;
import Levels.LevelPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FlexSeal extends Attack implements Collidable {

    private LevelPanel currentPanel;
    private int direction;

    public FlexSeal(LevelPanel currentPanel, int direction) throws IOException {
        super("Flex Seal", 5, ImageIO.read(new File("Assets/Flex.png")));
        this.setY(300);
        this.setX(464);
        this.currentPanel = currentPanel;
        this.direction = direction;
    }

    public void draw(Graphics g) {
        switch (this.direction) {
            case -1:
                this.setX(this.getX() - 1.5);
                this.setY(this.getY() - 0.3);
                break;
            case 1:
                this.setX(this.getX() - 1.5);
                this.setY(this.getY() + 0.3);
                break;
            case 2:
                this.setX(this.getX() - 1.5);
                this.setY(this.getY() + 0.15);
                break;
            case 3:
                this.setX(this.getX() - 1.5);
                this.setY(this.getY() - 0.15);
                break;
            case 0:
                this.setX(this.getX() - 1.5);
                break;
        }
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
