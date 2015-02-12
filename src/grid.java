import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

public class grid extends JComponent{
	private Graphics g;
	private Graphics2D g2d;
	public mover mover1;
	public grid(){
		this.mover1 = new mover(new Point2D.Double(100,200));
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.g = g;
		this.g2d = (Graphics2D) g;
		mover1.drawOn(g2d);
	}
}
