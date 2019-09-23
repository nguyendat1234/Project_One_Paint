import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.BufferedWriter;


import java.awt.event.WindowAdapter;


public interface HPaint 
{
		public void Ve(GraphicAdapter g);//dung de ve doi duong
		public boolean Kiemtra(Point p);//kiem tra diem có nam trong doi tuong ve
		public void dichuyen(Point x, Point y);//ham di chuyen doi tuong 
		public void ghidoituong(BufferedWriter w);
		public void taodoituong(Point x, Point y);
		
		
}
abstract class GraphicAdapter{
	public Graphics2D GraphicAdapter;
	public GraphicAdapter(){
	}
	public GraphicAdapter(Graphics g){
		this.GraphicAdapter = (Graphics2D) g;
	}
	public GraphicAdapter(Graphics2D g){
		this.GraphicAdapter = g;
	}
	public Graphics2D getGraphicAdapter() {
		return GraphicAdapter;
	}
	public void setGraphicAdapter(Graphics2D graphicAdapter) {
		GraphicAdapter = graphicAdapter;
	}
	public void setGraphicAdapter(Graphics graphicAdapter) {
		GraphicAdapter = (Graphics2D)graphicAdapter;
	}
	
}
