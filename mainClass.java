import java.awt.Dimension;

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
	}

}