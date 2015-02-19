import java.awt.Dimension;

import javax.swing.JFrame;

public class Main{
	public static grid grid = new grid();
	public static void main(String[] args){
		final JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1150, 750));
		frame.add(grid);
		// Makes frame visable
		frame.setVisible(true);
		timePass();
	}
	
	public static void timePass(){
		Runnable tickToc = new Runnable(){
			  @Override
			public void run(){
				  try {
						while (true) {
							Thread.sleep(30);								
							grid.mover1.updatePosition(1, 1);
							grid.repaint();
						}
					} catch (InterruptedException exception) {
						// Stop when interrupted
					}
			  }
		};
		new Thread(tickToc).start();
	}
	
}
