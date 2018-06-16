package baseCode;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {

	static Clip song;

	public static void play(String name) {

		try {
			song = AudioSystem.getClip();
			song.open(AudioSystem.getAudioInputStream(new File(name)));
			song.loop(song.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}

	}

	public static void stop() {
		song.stop();
		song = null;
	}
}
