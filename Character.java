import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import javax.swing.ImageIcon;


public class Character extends Mover{
	
	private String name;
	private ImageIcon img;

	public Character(Double CtPt) {
		super(CtPt);
	}
	
	public Character(Point2D.Double CtPt, String name, ImageIcon img){
		super(CtPt);
		this.name = name;
		this.img = img;
	}
	
	public void setCtPt(Point2D.Double CtPt){
		centerPoint = new Point2D.Double(CtPt.x,CtPt.y);
	}
	public Point2D.Double getCtPt(){
		return centerPoint;
	}
	
	@Override
	public void drawOn(Graphics2D g2d){
		g2d.drawImage(this.img.getImage(),(int)centerPoint.x-30,(int)centerPoint.y-50,60,100, null);
	}
}
