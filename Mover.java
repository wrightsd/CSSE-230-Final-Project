import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * 
 * This abstract class creates a Mover class.
 *
 * @author kongw.
 *         Created Feb 19, 2015.
 */
public abstract class Mover {
	
	protected Point2D.Double centerPoint;
	protected double Vx;
	protected double Vy;
	protected Point2D.Double endPoint;
	protected double ratio;
	
	/**
	 * 
	 * This is the constructor for a mover with a center point
	 *
	 * @param CtPt
	 */
	public Mover(Point2D.Double CtPt){
		this.centerPoint = CtPt;
		this.ratio = 0;
	}
	
	/**
	 * 
	 * This set up the end point for the mover to travel.
	 *
	 * @param endPoint
	 */
	public void setEndPoint(Point2D.Double endPoint){
		this.endPoint = endPoint;
		this.ratio = (endPoint.x-this.centerPoint.x)/(endPoint.y-this.centerPoint.y);
		if (endPoint.y- this.centerPoint.y > 0){
			this.Vy = .5;
			this.Vx = this.ratio*this.Vy;
		}
		else{
			this.Vy = -.5;
			this.Vx = this.ratio*this.Vy;
		}
	}
	
	/**
	 * 
	 * This method update the position of the mover
	 *
	 */
	public void updatePosition(){
		this.centerPoint.setLocation(this.centerPoint.x+this.Vx,this.centerPoint.y+this.Vy);
	}
	
	/**
	 * 
	 * This class draw the mover on the canvas
	 *
	 * @param g2d
	 */
	public abstract void drawOn(Graphics2D g2d);
}
