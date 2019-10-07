import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.BufferedWriter;
import java.io.IOException;


public class M_Rectangle implements C_2D
{
	
	
	private Rectangle r;
	private Color lc;
	private Color color = null;
	
	public M_Rectangle() {
		
	}
	public M_Rectangle(Rectangle r) {
		this.r = r;
	}
	public M_Rectangle(Rectangle r, Color lc) {
		this.r = r;
		this.lc = lc;
	}
	public M_Rectangle(Rectangle r, Color lc, Color c) {
		this.r = r;
		this.lc= lc;
		this.color = c;
	}

	

	@Override
	public void vedoituong(GraphicAdapter g) {
	
		if(getColor() == null){
    		g.getGraphicAdapter().setColor(this.getColor());
    		g.getGraphicAdapter().drawRect(this.getRect().x, this.getRect().y, this.getRect().width, this.getRect().height);
    	}
    	else{
    		g.getGraphicAdapter().setColor(this.getColor());
        	g.getGraphicAdapter().fillRect(this.getRect().x, this.getRect().y, this.getRect().width, this.getRect().height);
        	g.getGraphicAdapter().drawRect(this.getRect().x, this.getRect().y, this.getRect().width, this.getRect().height);
    	}
	}

	public Rectangle getRect() {
		
		return r;
	}
	public Color getColor() {
		
		return color;
	}
	@Override
	public void taodoituong(Point x, Point y) {
		
		setLineColor(GiaoDien.luachonmau);
		Rectangle r = new Rectangle(Math.min(x.x, y.x), Math.min(x.y, y.y), Math.abs(x.x - y.x), Math.abs(x.y - y.y));	
		this.setRect(r);
	}
	
	public void taohinhchunhat(int x, int y, int w, int h) {
		Rectangle r = new Rectangle(x, y, w, h);
	    this.setRect(r);
	}
	
	private void setLineColor(Color luachonmau) 
	{
		this.lc=luachonmau;
		
	}
	@Override
	public void dichuyen(Point x, Point y) {
		
		Rectangle r = new Rectangle(this.getRect().x + (y.x - x.x),this.getRect().y + (y.y - x.y), this.getRect().width, this.getRect().height);
    	this.setRect(r);
	}
	@Override
	public boolean Kiemtra(Point p) {
		
		return this.getRect().contains(p);
	}
	@Override
	public void ghidoituong(BufferedWriter w) {
		
		try {
			w.write(getClass().getSimpleName() + ";");
			w.write(getRect().x + ";" + getRect().y + ";" + getRect().width + ";" + getRect().height + ";");
			w.write(getLineColor().getRed() + ";" +getLineColor().getGreen() + ";" + getLineColor().getBlue() +";");
			if(getColor()==null){
				w.write("null" + ";" +"null" +";" + "null");
			}else{
				w.write(getColor().getRed() + ";" + getColor().getGreen() + ";" + getColor().getBlue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 public Color getLineColor() {
		
		return lc;
	}
	@Override
	public void domaudoituong(Color c) 
	{
		this.setColor(c);
		
	}

	private void setColor(Color c) {
	this.color=c;
		
	}
	private void setRect(Rectangle r2)
	{
		this.r=r2;
	}
	
}
