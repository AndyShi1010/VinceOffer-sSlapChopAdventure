package Levels;

import Entities.Boss;
import Entities.EnemySpawner;
import Entities.Player;
import Entities.SmallEnemy;
import MainGame.GameFrame;
import MainGame.GamePanel;

import javax.swing.*;
import java.awt.*;

public abstract class LevelPanel extends JPanel {

    private SmallEnemy levelEnemies;
    private Boss levelBoss;
    private Player player;
    private Image background;
    private boolean bossMode;
    private JFrame currentFrame;
    private EnemySpawner spawner;

    private boolean levelStart = false;
    private boolean levelOver = false;

    public LevelPanel(Player player, SmallEnemy levelEnemies, Boss levelBoss, Image background, GameFrame currentFrame) {
        this.player = player;
        this.levelEnemies = levelEnemies;
        this.levelBoss = levelBoss;
        this.background = background;
        this.setLayout(null);
        this.setBackground(new Color(0,0,0,0));
        this.bossMode = false;
        currentFrame.refreshFrame();
    }

    public abstract void paint (Graphics g);

    public SmallEnemy getLevelEnemies() {
        return levelEnemies;
    }

    public void setLevelEnemies(SmallEnemy levelEnemies) {
        this.levelEnemies = levelEnemies;
    }

    public Boss getLevelBoss() {
        return levelBoss;
    }

    public void setLevelBoss(Boss levelBoss) {
        this.levelBoss = levelBoss;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Image getLevelBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public EnemySpawner getSpawner() {
        return spawner;
    }

    public void setSpawner(EnemySpawner spawner) {
        this.spawner = spawner;
    }

    public boolean isBossMode() {
        return bossMode;
    }

    public void setBossMode(boolean bossMode) {
        this.bossMode = bossMode;
    }

    public boolean isLevelStart() {
        return levelStart;
    }

    public void setLevelStart(boolean levelStart) {
        this.levelStart = levelStart;
    }

    public boolean isLevelOver() {
        return levelOver;
    }

    public void setLevelOver(boolean levelOver) {
        this.levelOver = levelOver;
    }
}
