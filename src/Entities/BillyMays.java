package Entities;

import Attack.GreenGobbler;
import Attack.Oxiclean;

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

public class BillyMays extends Boss implements ActionListener {
    private ArrayList<Oxiclean> attackList = new ArrayList<Oxiclean>();

    public BillyMays() {
        super("Billy Mays", 80);
    }

    public BillyMays(int x, int y) throws IOException {
        super("Billy Mays", 80, ImageIO.read(new File("Assets/Billy.png")), ImageIO.read(new File("Assets/BillyMaysName.png")), x, y);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Assets/Oxiclean.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error playing sound.");
            ex.printStackTrace();
        }
        this.setAttackTimer(new Timer(500, this));
        this.getAttackTimer().start();
    }

    public void draw (Graphics g) {
        if (this.getHealth() > 0) {
            if (this.getxPos() > 464) {
                this.setxPos(this.getxPos() - 0.5);
            }
            g.drawImage(this.getSprite(), (int) this.getxPos(), (int) this.getyPos(), null);
            this.setHitBox(new Rectangle((int) this.getxPos(), (int) this.getyPos(), this.getSprite().getWidth(null), this.getSprite().getHeight(null)));
            //g.drawRect((int) this.getxPos(), (int) this.getyPos(), this.getSprite().getWidth(null), this.getSprite().getHeight(null));
        } else {
            this.getCurrentLevel().setBossMode(false);
            this.getCurrentLevel().setLevelOver(true);
            this.getAttackTimer().stop();
        }

        for (Oxiclean i: this.attackList) {
            i.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Assets/Shoot3.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error playing sound.");
            ex.printStackTrace();
        }

        try {
            this.attackList.add(0, new Oxiclean(this.getCurrentLevel()));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if (this.attackList.size() > 20) {
            this.attackList.remove(this.attackList.size() - 1);
        }
    }

}
