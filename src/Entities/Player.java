package Entities;

import Attack.Attack;
import Attack.BulletAttack;
import Attack.Collidable;
import Levels.LevelPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Player extends Entity implements Collidable {

    private ArrayList<Attack> attackList = new ArrayList<Attack>();
    private ArrayList<BulletAttack> bulletList = new ArrayList<BulletAttack>();
    private boolean isAttacking;

    public Player (String name, int health, Image sprite, int xPos, int yPos) {
        super(name, health, sprite, xPos, yPos);
        isAttacking = true;
    }

    public void draw (Graphics g) {
        g.drawImage(this.getSprite(), (int)this.getxPos(), (int)this.getyPos(), null);
    }

    public void updatePosition(int newX, int newY) {
        super.setxPos(newX);
        super.setyPos(newY);
    }

    public void setPanel (LevelPanel currentPanel) {
        super.setCurrentLevel(currentPanel);
    }

    public ArrayList<Attack> getAttackList() {
        return attackList;
    }

    public void setAttackList(ArrayList<Attack> attackList) {
        this.attackList = attackList;
    }

    public ArrayList<BulletAttack> getBulletList() {
        return bulletList;
    }

    public void setBulletList(ArrayList<BulletAttack> bulletList) {
        this.bulletList = bulletList;
    }

    @Override
    public boolean checkCollision(Entity object) {
        return (this.getHitBox().intersects(object.getHitBox()));
    }

    public void checkCollisionWithEveryEnemy() {
        ArrayList<SmallEnemy> enemies = this.getCurrentLevel().getSpawner().getEnemyArray();
        for (int i = 0; i < enemies.size(); i++) {
            SmallEnemy currentEnemy = enemies.get(i);
            if (checkCollision(currentEnemy)) {
                enemies.remove(i);
                this.getCurrentLevel().getSpawner().setEnemyArray(enemies);
                this.setHealth(this.getHealth() - currentEnemy.getMAX_HEALTH());
            }
        }
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }
}
