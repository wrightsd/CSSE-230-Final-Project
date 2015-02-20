import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;



public class mainClass {
	
	public JFrame frame;

	public static void main(String[] args) {
		
		// Creates Frame
				JFrame frame = new JFrame("The Fellowship of the Tree");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(new Dimension(1150, 750));

				mapMaker map = new mapMaker(frame);
				frame.add(map);
				// Makes frame visable
				frame.setVisible(true);
				try {
			         // Open an audio input stream.
			         URL url = mainClass.class.getClassLoader().getResource("Song.wav");
			         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			         // Get a sound clip resource.
			         Clip clip = AudioSystem.getClip();
			         // Open audio clip and load samples from the audio input stream.
			         clip.open(audioIn);
			         clip.start();
			      } catch (UnsupportedAudioFileException e) {
			         e.printStackTrace();
			      } catch (IOException e) {
			         e.printStackTrace();
			      } catch (LineUnavailableException e) {
			         e.printStackTrace();
			      }
				 	
	}


}