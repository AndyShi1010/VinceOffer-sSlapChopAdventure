package Levels;

import Entities.*;
import MainGame.AboutWindow;
import MainGame.GameFrame;
import MainGame.TitlePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LevelThreePanel extends LevelPanel implements ActionListener {
    private final Color HP_RED = new Color(229, 76, 76);
    private final Color HP_GREEN = new Color(105, 224, 94);
    private int playerMaxHealth;
    private int bossMaxHealth;
    private JFrame currentFrame;
    private Timer levelTextTimer = new Timer(3000, this);
    private Timer levelOverTimer = new Timer(3000, this);
    private Timer gameOverTimer = new Timer(3000, this);
    //private double oceanY = 480;

    public LevelThreePanel(GameFrame currentFrame) throws IOException {
        super(new VinceOffer(16, 208), new Zorbeez(), new BillyMays(), ImageIO.read(new File("Assets/Sky.png")), currentFrame);
        this.getPlayer().setPanel(this);
        this.addMouseMotionListener((VinceOffer)this.getPlayer());
        this.currentFrame = currentFrame;
        //this.setLevelBoss(new AnthonySullivan());
        currentFrame.requestFocus();
        super.setSpawner(new EnemySpawner(this));
        this.playerMaxHealth = this.getPlayer().getMAX_HEALTH();
        this.levelTextTimer.start();
        this.setLevelStart(true);
    }

    @Override
    public void paint (Graphics g) {
        g.drawImage(this.getLevelBackground(), 0 ,0 , null);
        if (this.isLevelStart()) {
            try {
                Image levelText = ImageIO.read(new File("Assets/LevelThreeText.png"));
                g.drawImage(levelText, ((this.getWidth()/2) - levelText.getWidth(null)/2), ((this.getHeight()/2) - levelText.getHeight(null)/2), null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.getLevelBoss().getHealth() <= 0) {
            try {
                Image levelText = ImageIO.read(new File("Assets/EndText.png"));
                g.drawImage(levelText, ((this.getWidth()/2) - levelText.getWidth(null)/2), ((this.getHeight()/2) - levelText.getHeight(null)/2), null);
                levelOverTimer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.isBossMode()) {
            try {
                g.drawImage(ImageIO.read(new File("Assets/Boss.png")), 16 , 16, null);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int bossCurrentHealth = this.getLevelBoss().getHealth();
            int bossMaxHealth = this.getLevelBoss().getMAX_HEALTH();
            if (bossCurrentHealth <= 0.3 * bossMaxHealth) {
                g.setColor(HP_RED.brighter());
                g.fillRect(100, 12, 516,32);
                g.setColor(HP_RED);
                g.fillRect(100, 12, (516 * bossCurrentHealth/bossMaxHealth),32);
            } else {
                g.setColor(HP_GREEN.brighter());
                g.fillRect(100, 12, 516,32);
                g.setColor(HP_GREEN);
                g.fillRect(100, 12, (516 * bossCurrentHealth/bossMaxHealth),32);
            }
            g.drawImage(this.getLevelBoss().getTextImage(), 116,16,null);
        }
        if (this.getPlayer().getHealth() > 0) {
            this.getSpawner().draw(g);
            this.getPlayer().draw(g);
            try {
                g.drawImage(ImageIO.read(new File("Assets/HP.png")), 8, 440, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int playerCurrentHealth = this.getPlayer().getHealth();
            int playerMaxHealth = this.getPlayer().getMAX_HEALTH();
            if (playerCurrentHealth <= 0.3*playerMaxHealth) {
                g.setColor(HP_RED.brighter());
                g.fillRect(56, 436, 264,32);
                g.setColor(HP_RED);
                g.fillRect(56, 436, (264 * playerCurrentHealth/playerMaxHealth),32);
            } else {
                g.setColor(HP_GREEN.brighter());
                g.fillRect(56, 436, 264,32);
                g.setColor(HP_GREEN);
                g.fillRect(56, 436, (264 * playerCurrentHealth/playerMaxHealth),32);
            }

        }
        else if (this.getPlayer().getHealth() <= 0){
            try {
                Image gameOverText = ImageIO.read(new File("Assets/GameOverText.png"));
                g.drawImage(gameOverText, ((this.getWidth()/2) - gameOverText.getWidth(null)/2), ((this.getHeight()/2) - gameOverText.getHeight(null)/2), null);

                gameOverTimer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == levelTextTimer) {
            this.setLevelStart(false);
            levelTextTimer.stop();
        }
        else if (e.getSource() == levelOverTimer) {
            this.levelOverTimer.stop();
            this.getPlayer().setAttacking(false);
            if (this.getLevelBoss().getAttackTimer() != null) {
                this.getLevelBoss().getAttackTimer().stop();
            }
            AboutWindow about = new AboutWindow();
            this.currentFrame.setContentPane(new TitlePanel(currentFrame));
            this.currentFrame.repaint();
            this.currentFrame.setSize(655, 519);
            this.currentFrame.setSize(656, 519);
        }
        else if (e.getSource() == gameOverTimer){
            gameOverTimer.stop();
            this.getPlayer().setAttacking(false);
            if (this.getLevelBoss().getAttackTimer() != null) {
                this.getLevelBoss().getAttackTimer().stop();
            }
            this.currentFrame.setContentPane(new TitlePanel(currentFrame));
            this.currentFrame.setSize(655, 519);
            this.currentFrame.setSize(656, 519);
            this.currentFrame.repaint();

        }
    }
}
