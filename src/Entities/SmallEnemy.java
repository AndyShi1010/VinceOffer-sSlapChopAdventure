package Entities;

import Attack.Collidable;

import java.awt.*;

public class SmallEnemy extends Entity implements Collidable {

    private final double moveSpeed;

    public SmallEnemy(String name, int health) {
        super(name, health);
        moveSpeed = Math.random() * 0.75 + 0.1;
    }

    public SmallEnemy(String name, int health, Image sprite, int x, int y) {
        super(name, health, sprite, x, y);
        moveSpeed = Math.random() * 0.75 + 0.1;
    }

    public void draw(Graphics g) {
        g.drawImage(this.getSprite(), (int)this.getxPos(), (int)this.getyPos(), null);
        this.setHitBox(new Rectangle((int)this.getxPos(), (int)this.getyPos(), this.getSprite().getWidth(null), this.getSprite().getHeight(null)));
        //g.drawRect((int)this.getxPos(), (int)this.getyPos(), this.getSprite().getWidth(null), this.getSprite().getHeight(null));
        //g.drawString(String.valueOf(this.getHealth()), (int)this.getxPos(), (int)this.getyPos());
        this.setxPos(this.getxPos() - this.moveSpeed);
    }

    @Override
    public boolean checkCollision(Entity object) {
        return false;
    }


}
