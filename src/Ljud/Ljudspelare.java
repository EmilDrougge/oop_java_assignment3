package Ljud;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Ljudspelare {
    public void playBlockSound() {
        try {
            File audioFile = new File("Sound/BlockSound.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void playSwingSound() {
        try {
            File audioFile = new File("Sound/Swish.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void playStartGameSound() {
        try {
            File audioFile = new File("Sound/StartGame.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void playWinningSound() {
        try {
            File audioFile = new File("Sound/WinningSound.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}


// https://uppbeat.io/sfx - Royalty free sound effects
