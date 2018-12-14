package MainGame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class GameRunner {
    public static void main (String[] args) {
        System.out.println("Game Start");
        GameFrame mainFrame = new GameFrame();

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Assets/FireDarer_Loop.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error playing sound.");
            ex.printStackTrace();
        }
    }
}
