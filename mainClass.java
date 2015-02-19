import java.awt.Dimension;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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

				 new Thread(new Runnable() {
					  // The wrapper thread is unnecessary, unless it blocks on the
					  // Clip finishing; see comments.
					    public void run() {
					      try {
					        Clip clip = AudioSystem.getClip();
					        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
					          mainClass.class.getResourceAsStream();
					        clip.open(inputStream);
					        clip.start(); 
					      } catch (Exception e) {
					        System.err.println(e.getMessage());
					      }
					    }
					  }).start();
				

	}


}