package Attack;

import Entities.Entity;

import java.awt.*;

public abstract class Attack {

    private int damage;
    private String name;
    private Image sprite;
    private Rectangle hitBox;
    private double x,y;

    public Attack(String name, int damage, Image sprite) {
        this.name = name;
        this.damage = damage;
        this.sprite = sprite;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void draw(Graphics g) {}
}
