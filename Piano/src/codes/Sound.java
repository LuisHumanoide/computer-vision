/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.applet.Main;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author HumanoideFilms
 */
public class Sound {

    public static void play(int pos) {
        try {
            playSound("sounds/"+(pos+1)+".wav");
        } catch (Exception ex) {
            Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void playSound(String file) throws Exception {
        // open the sound file as a Java input stream
        InputStream in = new FileInputStream(file);

        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
    }
}


