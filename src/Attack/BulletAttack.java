package Attack;

import Entities.Entity;
import Entities.SmallEnemy;
import Levels.LevelPanel;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BulletAttack extends Attack implements Collidable{

    private double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private LevelPanel currentPanel;

    public BulletAttack(double y, LevelPanel currentPanel) throws IOException {
        super("Bullet", 1, ImageIO.read(new File("Assets/Bullet.png")));
        this.setY(y + 28);
        this.setX(56);
        this.currentPanel = currentPanel;
    }

    @Override
    public void draw (Graphics g) {
        //System.out.println("Draw Bullet: " + x + ", " + y);
        g.drawImage(this.getSprite(), (int)this.getX() + this.getSprite().getWidth(null), (int)this.getY(), null);
        this.setHitBox(new Rectangle((int)this.getX() + this.getSprite().getWidth(null), (int)this.getY(), this.getSprite().getWidth(null), this.getSprite().getHeight(null)));
//        g.setColor(Color.RED);
//        g.drawRect((int)this.x + this.getSprite().getWidth(null), (int)this.y, this.getSprite().getWidth(null), this.getSprite().getHeight(null));

        //this.x += 1;
        this.setX(this.getX() + (screenWidth * 0.005));
        if (currentPanel.isBossMode()) {
            if (this.checkCollision(currentPanel.getLevelBoss())) {
                int bossCurrentHealth = currentPanel.getLevelBoss().getHealth();
                currentPanel.getLevelBoss().setHealth(bossCurrentHealth - this.getDamage());
                this.setDamage(0);
            }
        } else {
            this.checkCollisionWithEveryEnemy();
        }

    }

    @Override
    public boolean checkCollision(Entity object) {
        return (this.getHitBox().intersects(object.getHitBox()));
        //return (object.getHitBox().intersects(this.getHitBox()));
    }

    public void checkCollisionWithEveryEnemy() {
        ArrayList<SmallEnemy> enemies = currentPanel.getSpawner().getEnemyArray();
        for (int i = 0; i < enemies.size(); i++) {
            if (checkCollision(enemies.get(i))) {
                enemies.get(i).setHealth(enemies.get(i).getHealth() - this.getDamage());
                this.setDamage(0);
                currentPanel.getSpawner().setEnemyArray(enemies);
            }
        }
    }

}
