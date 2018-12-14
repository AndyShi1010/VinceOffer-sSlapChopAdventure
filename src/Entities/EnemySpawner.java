package Entities;

import Levels.LevelOnePanel;
import Levels.LevelPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;


public class EnemySpawner implements ActionListener {

    private Timer spawnerTimer;
    private Timer spawnIntervalTimer;
    private Timer bossDelay;
    private ArrayList<SmallEnemy> enemyArray = new ArrayList<SmallEnemy>();
    private SmallEnemy levelEnemies;
    private Boss levelBoss;
    private LevelPanel level;

    private final int ENEMY_SPAWN_RATE = 1000;
    private final int ENEMY_SPAWN_DELAY = 3000;
    private final int ENEMY_SPAWN_TIME = 30000;
    private final int BOSS_SPAWN_DELAY = 3000;

    public EnemySpawner (LevelPanel level) {
        spawnerTimer = new Timer(ENEMY_SPAWN_TIME + ENEMY_SPAWN_DELAY, this);
        spawnIntervalTimer = new Timer(ENEMY_SPAWN_RATE, this);
        spawnIntervalTimer.setInitialDelay(ENEMY_SPAWN_DELAY);
        bossDelay = new Timer(BOSS_SPAWN_DELAY, this);
        spawnerTimer.start();
        spawnIntervalTimer.start();
        this.level = level;
        levelEnemies = level.getLevelEnemies();
        levelBoss = level.getLevelBoss();
    }

    public void draw (Graphics g) {
//        System.out.println(enemyArray.size());
        for (int i = 0; i < enemyArray.size(); i++) {
            //System.out.println(enemyArray.get(i).getHealth());
            if ((enemyArray.get(i).getHealth() < 1) || (enemyArray.get(i).getxPos() < -60)){
                enemyArray.remove(i);
                i--;
            } else {
                enemyArray.get(i).draw(g);
            }
        }
        if (level.isBossMode()) {
            level.getLevelBoss().draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == spawnIntervalTimer) {
            System.out.println("Enemy");
            int y = (int)(Math.random() * 344) + 16;
            if (levelEnemies instanceof MightyThirsty) {
                try {
                    MightyThirsty enemy = new MightyThirsty(640, y);
                    enemy.setCurrentLevel(level);
                    enemyArray.add(0, enemy);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (levelEnemies instanceof FlexTape) {
                try {
                    FlexTape enemy = new FlexTape(640, y);
                    enemy.setCurrentLevel(level);
                    enemyArray.add(0, enemy);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (levelEnemies instanceof Zorbeez) {
                try {
                    Zorbeez enemy = new Zorbeez(640, y);
                    enemy.setCurrentLevel(level);
                    enemyArray.add(0, enemy);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        }
        if (e.getSource() == spawnerTimer) {
            System.out.println("Enemy Stop");
            spawnerTimer.stop();
            spawnIntervalTimer.stop();
            bossDelay.start();
        }
        if (e.getSource() == bossDelay) {
            bossDelay.stop();
            System.out.println("Boss");
            this.level.setBossMode(true);
            this.enemyArray.clear();
            if (levelBoss instanceof AnthonySullivan) {
                System.out.println("Anthony Sullivan");
                try {
                    AnthonySullivan boss = new AnthonySullivan(640, 200);
                    boss.setCurrentLevel(level);
                    level.setLevelBoss(boss);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (levelBoss instanceof PhilSwift) {
                System.out.println("Phil Swift");
                try {
                    PhilSwift boss = new PhilSwift(640, 264);
                    boss.setCurrentLevel(level);
                    level.setLevelBoss(boss);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (levelBoss instanceof BillyMays) {
                System.out.println("Billy Mays");
                try {
                    BillyMays boss = new BillyMays(640, 200);
                    boss.setCurrentLevel(level);
                    level.setLevelBoss(boss);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public ArrayList<SmallEnemy> getEnemyArray() {
        return enemyArray;
    }

    public void setEnemyArray(ArrayList<SmallEnemy> enemyArray) {
        this.enemyArray = enemyArray;
    }

}
