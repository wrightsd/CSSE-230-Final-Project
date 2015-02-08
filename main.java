import java.awt.Dimension;

import javax.swing.JFrame;


public class main {
	
	public JFrame frame;

	public static void main(String[] args) {
		
		// Creates Frame
				final JFrame frame = new JFrame("The Fellowship of the Tree");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(new Dimension(1150, 750));

				new mapMaker(frame);

				// Makes frame visable
				frame.setVisible(true);

	}

}
