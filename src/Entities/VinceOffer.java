package Entities;


import Attack.Attack;
import Attack.BulletAttack;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class VinceOffer extends Player implements MouseMotionListener, ActionListener {
    private Timer attackRateTimer;

    public VinceOffer(int x, int y) throws IOException {
        super("Vince Offer", 25, ImageIO.read(new File("Assets/SlapChopper.png")), x ,y);
        System.out.println("New Vince");
        attackRateTimer = new Timer(200, this);
        attackRateTimer.setInitialDelay(3000);
        attackRateTimer.start();
    }

    public void draw (Graphics g) {
        g.drawImage(this.getSprite(), (int)this.getxPos(), (int)this.getyPos(), null);
        this.setHitBox(new Rectangle((int)this.getxPos() + 20, (int)this.getyPos() + 20, this.getSprite().getWidth(null) - 20, this.getSprite().getHeight(null) - 20));
        //g.drawRect((int)this.getxPos() + 20, (int)this.getyPos() + 20, this.getSprite().getWidth(null) - 20, this.getSprite().getHeight(null) - 20);
        for (BulletAttack i: this.getBulletList()) {
            i.draw(g);
        }
       // g.drawString(String.valueOf(this.getHealth()), (int)this.getxPos(), (int)this.getyPos());
        this.checkCollisionWithEveryEnemy();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (e.getY() < 384 && e.getY() > 0) {
            super.updatePosition((int)this.getxPos(), e.getY() - this.getSprite().getHeight(null)/2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == attackRateTimer && this.isAttacking()) {
            try {
                try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Assets/Bullet.wav").getAbsoluteFile());
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
                } catch(Exception ex) {
                    System.out.println("Error playing sound.");
                    ex.printStackTrace();
                }
                this.getBulletList().add(0, new BulletAttack(this.getyPos(), this.getCurrentLevel()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (this.getBulletList().size() > 20) {
                this.getBulletList().remove(this.getBulletList().size() - 1);
            }
        }
    }

}
