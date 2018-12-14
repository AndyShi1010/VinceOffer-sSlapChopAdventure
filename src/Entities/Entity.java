package Entities;

import Levels.LevelPanel;

import javax.swing.*;
import java.awt.*;

public abstract class Entity extends JComponent {
    private final int MAX_HEALTH;
    private int health;
    private String name;
    private Image sprite;
    private double xPos, yPos;
    private LevelPanel currentLevel;
    private Rectangle hitBox;

    public Entity(String name, int health) {
        this.name = name;
        this.MAX_HEALTH = health;
        this.health = health;
    }

    public Entity(String name, int health, Image sprite, int xPos, int yPos) {
        this.name = name;
        this.MAX_HEALTH = health;
        this.health = health;
        this.sprite = sprite;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void paint (Graphics g) {
        g.drawImage(this.sprite ,(int)this.xPos, (int)this.yPos, null);
    }

    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
        currentLevel.repaint();
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
        currentLevel.repaint();
    }

    public LevelPanel getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(LevelPanel currentLevel) {
        this.currentLevel = currentLevel;
        currentLevel.repaint();
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void setHitBox(Rectangle hitBox) {
        //System.out.println("Setting Hitbox");
        this.hitBox = hitBox;
    }

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }
}
