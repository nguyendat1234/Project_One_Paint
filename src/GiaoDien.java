import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;


public class GiaoDien extends JFrame
{
	
	public static String luachon = "";
	static Color luachonmau = Color.white;
	public static ArrayList<Paint_F>paint1=new ArrayList<Paint_F>();
	private  JPanel Cpanel;
	public static GiaoDien frame; 
	private JComboBox colors;
	private String colorOptions[]=
	    {"Black","Blue","Cyan","Dark Gray","Gray","Green","Light Gray",
	        "Magenta","Orange","Pink","Red","White","Yellow"};
	 private Color colorArray[]=
		    {Color.BLACK , Color.BLUE , Color.CYAN , Color.darkGray , Color.GRAY , 
		        Color.GREEN, Color.lightGray , Color.MAGENTA , Color.ORANGE , 
		    Color.PINK , Color.RED , Color.WHITE , Color.YELLOW};	 
	 public static void main(String[] args) {
			try{
	    		frame = new GiaoDien();
	    		frame.setVisible(true);
	    		
	       }catch (Exception e) {
				e.printStackTrace();
		}
		 
		}
	 
	public GiaoDien()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Đồ Án Paint");
		setSize(1000, 600);
		setMinimumSize(getSize());
		//tao menu 
		
		JMenuBar menubar =new JMenuBar();
		setJMenuBar(menubar);
		JMenu mmenubar =new JMenu("Tùy chọn");
		JMenu mmenubar1 =new JMenu("Giới Thiệu");
		menubar.add(mmenubar);
		menubar.add(mmenubar1);
		
		//
		JMenuItem menunew =new JMenuItem("Mới");
		menunew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				luachon = "";
				OpenFile.image = null;
				paint1.clear();	
				repaint();
				
			}
		});		
			mmenubar.add(menunew);
		//menu open
		JMenuItem mnOpen = new JMenuItem("Mở");
		mnOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                luachon="Open";
            	GiaoDien.paint1.clear(); 
				new OpenFile();
            }
        });
		mmenubar.add(mnOpen);
		//menu save 
		JMenuItem mnNew = new JMenuItem("Lưu");
		mnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luachon = "Save";
				GiaoDien.paint1.clear();
				new SaveFile();
			}
		});
		mmenubar.add(mnNew);
		//menu exit
		JMenuItem mnExit = new JMenuItem("Thoát");
		mnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luachon = "Exit";
				System.exit(0);
			}
		});
		mmenubar.add(mnExit);
		
		//panel main
		Cpanel = new JPanel();
		Cpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		Cpanel.setLayout(new BorderLayout(0, 0));
		Cpanel.setBackground(Color.white);
		
		setContentPane(Cpanel);
		// tao ra doi tuong sap xep tu trai sang phai
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(Color.white);
		Cpanel.add(panel, BorderLayout.NORTH);
		//set button
		//button point
		JButton btnPoint = new JButton("Điểm");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				luachon= "Điểm";
			}
		});
		panel.add(btnPoint);
		//button line
		JButton btnLine = new JButton("Đường");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				luachon= "Đường Thăng";
			}
		});
		panel.add(btnLine);
		//button R

		JButton btnR = new JButton("Hình Chữ Nhật");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				luachon= "1";
			}
		});
		panel.add(btnR);
		//button S
		JButton btnS = new JButton("Hình Vuông");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				luachon= "Hình Vuông";
			}
		});
		panel.add(btnS);
		//button C
		JButton btnC = new JButton("Hình Tròn");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				luachon= "Hình Tròn";
			}
		});
		panel.add(btnC);
		//button O
		JButton btnO = new JButton("Hình Elip");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				luachon= "Hình Elip";
			}
		});
		panel.add(btnO);
		// button fill 
		JButton btnFill = new JButton("Đổ Màu");
		btnFill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				luachon= "Đổ Màu";
			}
		});
		panel.add(btnFill);
		//button select color
		
		//move
		 
			JButton btnMove = new JButton("Di chuyển");
			btnMove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					luachon= "di chuyển";
				}
			});
			panel.add(btnMove);
			//delete	 
				JButton btnDelete = new JButton("Xóa");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						luachon= "Xóa";
					}
				});
			panel.add(btnDelete);
			//select panel color
				JPanel pnlColor = new JPanel();
				pnlColor.setBackground(Color.white);
				pnlColor.setSize(20, getHeight());
				panel.add(pnlColor, BorderLayout.SOUTH);
			// select color
				Cpanel.add(new Paint_Event(), BorderLayout.CENTER);
				validate();

				
				
			//colors =new JComboBox(colorOptions);
			//panel.add(colors);
			
	}
	
	
	
	
	
}
