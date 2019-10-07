import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class Paint_Event extends JComponent
{
	public Point start, end;
	public Paint_F temp;
	public Paint_Event() 
	{
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) //được gọi khi một nút chuột được nhấn và con trỏ chuột ở trên component.
			{
			start=new Point(e.getX(),e.getY());
			end=start;
			if(GiaoDien.luachon == "Di chuyen") //nếu click "di chuyển" 
			{
				
		          for(int i = GiaoDien.paint1.size() - 1; i>=0; i=i-1) //khoảng cách của form
		          {
		        	  Paint_F pt = GiaoDien.paint1.get(i);
	        		  if(pt.Kiemtra(start)){   //kiểm tra xem điểm đầu có hợp lệ 
	        			  temp = pt;
	        			  GiaoDien.paint1.remove(pt); //trả về
	        			  break;
	        		  }
		          }
	          }
			else if(GiaoDien.luachon == "Xóa" ){
		          for(int i = GiaoDien.paint1.size() - 1; i>=0; i=i-1){
		        	  Paint_F pt = GiaoDien.paint1.get(i);
		        	    if(pt.Kiemtra(start)){
		        			  temp = null;
		        			  GiaoDien.paint1.remove(pt);
		        			  break;
		        	    }
		          }
	          }
			}
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				Point p = new Point(e.getX(), e.getY());
				if(GiaoDien.luachon =="Hình Chữ Nhật"){
	        		M_Rectangle obj = new M_Rectangle();
	        		obj.taodoituong(start,p);
	    			GiaoDien.paint1.add(obj);
				}
				else if(GiaoDien.luachon == "Đổ Màu"){
	        		for(int i = GiaoDien.paint1.size() - 1; i>=0; i=i-1){
	        			Paint_F pt = GiaoDien.paint1.get(i);
	        			try{
	        				C_2D s = (C_2D)pt;
	        				if(s.Kiemtra(start)){
		        				try{
		        					s.domaudoituong(GiaoDien.luachonmau);
		        				}
		        				catch(Exception ex){}
			        			break;
		        			}
	        			}
	        			catch(Exception ex){}
	        		}
	        	}
	        	else if(GiaoDien.luachon =="di chuyển"){
	        			if(temp.Kiemtra(start)){
	        				temp.dichuyen(start, p);
        					GiaoDien.paint1.add(temp);
	        			}
	        		}
	        	start = null;
	        	end = null;
	        	repaint();
	        
			}
		
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() 
		{
			public void mouseDragged(MouseEvent e) //phương thức này gọi khi người dùng kéo thả chuột 
			{
	        	end = new Point(e.getX(), e.getY());
	        	repaint();
	        }
		});
		
	}
	public void paint(Graphics g)
	{
		GraphicAdapter g2 = new GraphicAdapter() {
		};
		for (Paint_F pt : GiaoDien.paint1)
		{
			pt.vedoituong(g2);
		}
		if (start != null && end != null) {
			if(GiaoDien.luachon == "1"){
				System.out.print("đs");
				M_Rectangle obj = new M_Rectangle();
				obj.taodoituong(start, end);
				
				obj.vedoituong(g2);
			}
			else if(GiaoDien.luachon == "Di chuyển"){
    			if(temp instanceof M_Rectangle){
    				M_Rectangle r = (M_Rectangle)temp;
    				if(r.Kiemtra(start)){
    					if(r.getColor()==null){
    						g2.getGraphicAdapter().setColor(r.getLineColor());
    						g2.getGraphicAdapter().drawRect(r.getRect().x + end.x - start.x, r.getRect().y + end.y - start.y, r.getRect().width, r.getRect().height);
    					}else {
    						g2.getGraphicAdapter().setColor(r.getColor());
    						g2.getGraphicAdapter().fillRect(r.getRect().x + end.x - start.x, r.getRect().y + end.y - start.y, r.getRect().width, r.getRect().height);
    						g2.getGraphicAdapter().drawRect(r.getRect().x + end.x - start.x, r.getRect().y + end.y - start.y, r.getRect().width, r.getRect().height);
						}
    				}
    			}
		
		
		}
			}
	
}}
