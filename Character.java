import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.ImageIcon;

/**
 * 
 * This class creates characters, which extends mover class
 *
 * @author kongw.
 *         Created Feb 19, 2015.
 */
public class Character extends Mover{
	
	private ImageIcon img;

	/**
	 * 
	 * This is the constructor for character with the center point
	 *
	 * @param CtPt
	 */
	public Character(Double CtPt) {
		super(CtPt);
	}
	
	/**
	 * 
	 * This is the constructor for character with a center point, a name and
	 * a image.
	 *
	 * @param CtPt
	 * @param name
	 * @param img
	 */
	public Character(Point2D.Double CtPt, String name, ImageIcon img){
		super(CtPt);
		this.img = img;
	}
	
	/**
	 * 
	 * Set a center point
	 *
	 * @param CtPt
	 */
	public void setCtPt(Point2D.Double CtPt){
		this.centerPoint = new Point2D.Double(CtPt.x,CtPt.y);
	}
	
	/**
	 * 
	 * Get the center point 
	 *
	 * @return
	 */
	public Point2D.Double getCtPt(){
		return this.centerPoint;
	}
	
	/**
	 * This method draws the mover on the canvas
	 * 
	 */
	@Override
	public void drawOn(Graphics2D g2d){
		g2d.drawImage(this.img.getImage(),(int)this.centerPoint.x-30,(int)this.centerPoint.y-50,60,100, null);
	}
}
