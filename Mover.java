import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


public class Mover {
	
	private Point2D.Double centerPoint;

	public Mover(Point2D.Double CtPt){
		this.centerPoint = CtPt;
	}
	
	public void updatePosition(double Vx, double Vy){
		this.centerPoint.setLocation(this.centerPoint.x+5*Vx,this.centerPoint.y+5*Vy);
	}
	
	public void drawOn(Graphics2D g2d){
		Ellipse2D.Double newE = new Ellipse2D.Double(this.centerPoint.x,this.centerPoint.y,10,10);
		g2d.draw(newE);
		g2d.setColor(Color.blue);
		g2d.fill(newE);
	}
}
