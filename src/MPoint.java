import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.IOException;



public class MPoint
{
	//gom 2 doi tuong la diem va mau 
	private Point diem;
	private Color mau=Color.black;
	public MPoint() {}
		
	
	public MPoint(Point p) {
		this.diem = p;
	}
	
	public MPoint(Point p, Color c) 
	{
		this.diem = p;
		this.mau = c;
	}
	public void Ve(GraphicAdapter g)
	{
		g.GraphicAdapter.setColor(getcolor());
		g.getGraphicAdapter().drawLine(getPoint().x, getPoint().y,getPoint().x, getPoint().y);
	}

	public void dichyen(Point x, Point y)
	{
		setPoint(y);
	}
	public boolean Kiemtra(Point p) {
		if(p.x == getPoint().x && p.y == getPoint().y){
			return true;
		}
		return false;
    }
	
	public void ghidoituong(BufferedWriter b){
    	try {
    		b.write(getClass().getSimpleName() + ";");
    		b.write(getPoint().x + ";" + getPoint().y + ";");
    		b.write(getcolor().getRed() + ";" + getcolor().getGreen() + ";" + getcolor().getBlue());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public void taodoituong(Point start, Point end){
    	Point p = new Point(start.x, start.y);
    	setPoint(p);
    	setcolor(GiaoDien.luachonmau);
    }
	
	private void setcolor(Color color) {
		
		color=color;
	}
	private void setPoint(Point y) {
		this.diem = diem;
	}
	private Point getPoint() {
	return diem;
	}
	private Color getcolor() {
		return mau;
	}
	
	

	
	
}
