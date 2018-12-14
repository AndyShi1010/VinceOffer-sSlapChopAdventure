package Entities;

import Attack.Attack;
import Attack.Collidable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Boss extends Entity implements Collidable {

    private Image textImage;
    private Timer attackTimer;

    public Boss(String name, int health) {
        super(name, health);
    }

    public Boss(String name, int health, Image sprite, Image text, int x, int y) {
        super(name, health, sprite, x, y);
        this.textImage = text;
    }

    public void draw(Graphics g) {}

    @Override
    public boolean checkCollision(Entity object) {
        return false;
    }

    public Image getTextImage() {
        return textImage;
    }

    public void setTextImage(Image textImage) {
        this.textImage = textImage;
    }

    public Timer getAttackTimer() {
        return attackTimer;
    }

    public void setAttackTimer(Timer attackTimer) {
        this.attackTimer = attackTimer;
    }
}
