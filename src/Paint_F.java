import java.awt.Point;
import java.io.BufferedWriter;

public interface Paint_F 
{
	public boolean Kiemtra(Point p);//ham kiem tra doi tuong
	public void vedoituong(GraphicAdapter g);//ham ve duoi tuong
	public void taodoituong(Point x, Point y);//ham tao doi tuong tu hai diem 
	public void dichuyen(Point x, Point y);//ham di chuyen doi tuong
	public void ghidoituong(BufferedWriter w);//ghi doi tuong duoi dang file.
	

}
