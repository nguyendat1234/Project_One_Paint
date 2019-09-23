import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Line2D;
import javax.sound.sampled.Line;


import java.awt.Graphics2D;

public class MLine 
{
	public Line duong;
	private Color mau;
	public MLine() {}
	
	public MLine(Line l)
	{
		this.duong = l;
	}

	
	public void draw(GraphicAdapter g){
		g.getGraphicAdapter().setColor(getColor());
		g.getGraphicAdapter().drawLine();
	}
	public Color getColor() {
		return mau;
	}public Line getLine() {
		return duong;
	}
	public void setLine(Line line) 
	{
		this.duong = line;
	}
}
