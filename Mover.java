import java.awt.Graphics2D;
import java.awt.geom.Point2D;


public abstract class Mover {
	
	protected Point2D.Double centerPoint;
	protected double Vx;
	protected double Vy;
	protected Point2D.Double endPoint;
	protected double ratio;

	public Mover(Point2D.Double CtPt){
		this.centerPoint = CtPt;
		this.ratio = 0;
	}
	
	public void setEndPoint(Point2D.Double endPoint){
		this.endPoint = endPoint;
		ratio = (endPoint.x-this.centerPoint.x)/(endPoint.y-this.centerPoint.y);
		if (endPoint.y- this.centerPoint.y > 0){
			Vy = .5;
			Vx = ratio*Vy;
		}
		else{
			Vy = -.5;
			Vx = ratio*Vy;
		}
	}
	
	public void updatePosition(){
		this.centerPoint.setLocation(this.centerPoint.x+Vx,this.centerPoint.y+Vy);
	}
	
	public abstract void drawOn(Graphics2D g2d);
}
