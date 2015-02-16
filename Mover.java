import java.awt.Graphics2D;
import java.awt.geom.Point2D;


public abstract class Mover {
	
	protected Point2D.Double centerPoint;

	public Mover(Point2D.Double CtPt){
		this.centerPoint = CtPt;
	}
	
	public void updatePosition(Point2D.Double endPoint){
		double Vx = (endPoint.x-this.centerPoint.x)/100000;
		double Vy = (endPoint.y-this.centerPoint.y)/100000;
		this.centerPoint.setLocation(this.centerPoint.x+5*Vx,this.centerPoint.y+5*Vy);
	}
	
	public abstract void drawOn(Graphics2D g2d);
}
