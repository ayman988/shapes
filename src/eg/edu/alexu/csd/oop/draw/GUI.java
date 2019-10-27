package eg.edu.alexu.csd.oop.draw;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.*;
import javax.swing.*;
public class GUI extends JPanel  {
	private JFrame frame;
	int xbegin;
	int ybegin;
	int xend;
	int yend;
	Color sc;
	Color fc;
	DrawingEngine_I x = new DrawingEngine_I();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});   
	}
	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	    final int CANVAS_WIDTH = 1000;
	    final int CANVAS_HEIGHT = 614;
	    DrawCanvas canvas = new DrawCanvas();
	    canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
	    canvas.setBackground(Color.white);
	    frame.setContentPane(canvas);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setTitle("Paint");
	    frame.setVisible(true); 
	    
	    

	    
//=============================== Drawing Ellipse ====================================================================	    
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Ellipse");
		tglbtnNewToggleButton.setBounds(0, 135, 74, 60);
		tglbtnNewToggleButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {		
				if( tglbtnNewToggleButton.isSelected())
				{
					 canvas.addMouseListener(new MouseAdapter() {				
						   public void mouseClicked(MouseEvent me){
							   int x,y;
						    x = me.getX(); 
						    y = me.getY();
							Shape ellzz = new Ellipse();
							ellzz.setPosition(new Point(x-25,y-25));
							//set prop
							HashMap<String, Double > hm = new HashMap<>();
							hm.put("Width", 50.0);
							hm.put("Height", 50.0);
							ellzz.setProperties(hm);
							ellzz.setColor(Color.black);
							ellzz.setFillColor(Color.green);
							GUI.this.x.addShape(ellzz);
							canvas.repaint();
							
						   }
						  });
				}
				else
				{
					MouseListener[] mouseListeners = canvas.getMouseListeners();
					for (MouseListener mouseListener : mouseListeners) {
					   canvas.removeMouseListener(mouseListener);
				}
				}			
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(tglbtnNewToggleButton);
		frame.setBounds(0, 0, 1000, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		
//****************************************Line Toggle Button****************************************************************			
				JToggleButton tglbtnLine = new JToggleButton("Line");
				//Icon icon3 = new ImageIcon("");
				//tglbtnNewToggleButton_1.setIcon(icon3);
				tglbtnLine.setBounds(0, 89, 74, 53);
				tglbtnLine.addChangeListener(new ChangeListener() {
					 int xbegin,ybegin,xend,yend;
					public void stateChanged(ChangeEvent e) {
						if(tglbtnLine.isSelected())
						{				
							Shape ellzzline = new LineSegment();
							x.addShape(ellzzline);
							ellzzline.setColor(sc);
							ellzzline.setFillColor(fc);	
							//setpropertries
							HashMap<String, Double > kk = new HashMap<>();
							kk.put("X1", 0.0);
							kk.put("Y1",0.0);
							kk.put("X2", 0.0);
							kk.put("Y2", 0.0);
							canvas.addMouseListener(new MouseAdapter() {
								 @Override
								public void mousePressed(MouseEvent e) {
									super.mousePressed(e);
									//System.out.println("holaaaaaaa"+e.getX()+"  "+e.getY());
									xbegin = e.getX();
									ybegin = e.getY();
									xend = xbegin; 
									yend =ybegin;
									kk.replace("X1", (double)xbegin);
									kk.replace("Y1", (double)ybegin);
									kk.replace("X2", (double)xend);
									kk.replace("Y2", (double)yend);
									ellzzline.setProperties(kk);
									System.out.println("mousepreess");
									canvas.repaint();
								}
								 @Override
								public void mouseReleased(MouseEvent e) {
									super.mouseReleased(e);
									xend = e.getX();
									yend = e.getY();
									kk.replace("X1", (double)xbegin);
									kk.replace("Y1", (double)ybegin);
									kk.replace("X2", (double)xend);
									kk.replace("Y2", (double)yend);
									ellzzline.setProperties(kk);
									//System.out.println("mousea7aaaaaaaa");
									canvas.repaint();
								}
							});
							canvas.addMouseMotionListener(new MouseMotionAdapter() {
								@Override
								public void mouseDragged(MouseEvent e) {
									super.mouseDragged(e);
									xend = e.getX();
									yend = e.getY();
									kk.replace("X2", (double)xend);
									kk.replace("Y2", (double)yend);
									 ellzzline.setProperties(kk);
									//System.out.println("mousepreessMASHSYYYYYYY");
									canvas.repaint();
									
								}
							});
						}
						else
						{
							MouseListener[] mouseListeners = canvas.getMouseListeners();
							for (MouseListener mouseListener : mouseListeners) {
								canvas.removeMouseListener(mouseListener);
							}
							if(canvas != null)
							{
								MouseListener[] mouseListeners2 = canvas.getMouseListeners();
								for (MouseListener mouseListener : mouseListeners2) {
									canvas.removeMouseListener(mouseListener);
									//System.out.println("heeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
								}
								MouseMotionListener[] mousem = canvas.getMouseMotionListeners();
								for (MouseMotionListener mouseListener : mousem) {
									canvas.removeMouseMotionListener(mouseListener);
									//System.out.println("heeeeeeeeasdadadadasdeeeeeeeeeeeee");
								}
							}
						}
					}
				});
				frame.getContentPane().add(tglbtnLine);
//============================ Draw A Triangle ===============================================================					
				JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Triangle");
				//Icon icon2 = new ImageIcon("");
				//tglbtnNewToggleButton_1.setIcon(icon2);
				tglbtnNewToggleButton_1.addChangeListener(new ChangeListener() {
					int x1,y1,x2,y2,x3,y3;// int flag=0;
					public void stateChanged(ChangeEvent e) {
						if(tglbtnNewToggleButton_1.isSelected())
						{	
							Shape ellzztirango = new Triangle();
							x.addShape(ellzztirango);
							ellzztirango.setColor(sc);
							ellzztirango.setFillColor(fc);	
							HashMap<String, Double > tm = new HashMap<>();
							tm.put("x1", 0.0);
							tm.put("y1",0.0);
							tm.put("x2", 0.0);
							tm.put("y2", 0.0);
							tm.put("x3", 0.0);
							tm.put("y3", 0.0);
							canvas.addMouseListener(new MouseAdapter() {
								int flag=0;
								public void mousePressed(MouseEvent e) {
									if(flag == 0)
									{
										System.out.println("tany mra");
										x1 = e.getX();
										y1 = e.getY();
										x2 = x1; 
										y2 =y1;
										x3=x1;
										y3=y1;
										//System.out.println("kosss"+x1 + " "+y1+"  "+x2+" "+y2+"  "+x3+" "+y3);
										tm.replace("x1", (double)x1);
										tm.replace("y1", (double)y1);
										tm.replace("x2", (double)x2);
										tm.replace("y2", (double)y2);
										tm.replace("x3", (double)x3);
										tm.replace("y3", (double)y3);
										//System.out.println("a7aaa"+x1 + " "+y1+"  "+x2+" "+y2+"  "+x3+" "+y3);
										ellzztirango.setProperties(tm);
										canvas.repaint();
										flag=1;
									}
									else 
									{
										x3=e.getX();
										y3=e.getY();
										//System.out.println("a7aaa"+x1 + " "+y1+"  "+x2+" "+y2+"  "+x3+" "+y3);
										tm.replace("x1",(double)x1);
										tm.replace("y1",(double)y1);
										tm.replace("x2", (double)x2);
										tm.replace("y2", (double)y2);
										tm.replace("x3", (double)x3);
										tm.replace("y3", (double)y3);
										ellzztirango.setProperties(tm);
										canvas.repaint();
									}
								};
								public void mouseReleased(MouseEvent e) {
									if(flag==0)
									{
										x2 = e.getX();
										y2 = e.getY();
										x3=x2;
										y3=y2;
										tm.replace("x1",(double)x1);
										tm.replace("y1",(double)y1);
										tm.replace("x2", (double)x2);
										tm.replace("y2", (double)y2);
										tm.replace("x3", (double)x3);
										tm.replace("y3", (double)y3);
										ellzztirango.setProperties(tm);
										canvas.repaint();
									}
									else
									{
										x3=e.getX();
										y3=e.getY();
										tm.replace("x1",(double)x1);
										tm.replace("y1",(double)y1);
										tm.replace("x2", (double)x2);
										tm.replace("y2", (double)y2);
										tm.replace("x3", (double)x3);
										tm.replace("y3", (double)y3);
										ellzztirango.setProperties(tm);
										canvas.repaint();
									}
								};
							});
							canvas.addMouseMotionListener(new MouseMotionListener() {
								@Override
								public void mouseMoved(MouseEvent e) {}
								@Override
								public void mouseDragged(MouseEvent e) {
									x2 = e.getX();
									y2 = e.getY();
									x3=e.getX();
									y3=e.getY();
									tm.replace("x1",(double)x1);
									tm.replace("y1",(double)y1);
									tm.replace("x2", (double)x2);
									tm.replace("y2", (double)y2);
									tm.replace("x3", (double)x3);
									tm.replace("y3", (double)y3);
									ellzztirango.setProperties(tm);
								    canvas.repaint();	
								}
							});
						}
						else
						{
							MouseListener[] mouseListeners = canvas.getMouseListeners();
							for (MouseListener mouseListener : mouseListeners) {
								canvas.removeMouseListener(mouseListener);
							}
							if(canvas != null)
							{
								MouseListener[] mouseListeners2 = canvas.getMouseListeners();
								for (MouseListener mouseListener : mouseListeners2) {
									canvas.removeMouseListener(mouseListener);
								}
								MouseMotionListener[] mousem = canvas.getMouseMotionListeners();
								for (MouseMotionListener mouseListener : mousem) {
									canvas.removeMouseMotionListener(mouseListener);
								}
							}	
						}
					}
				});
				tglbtnNewToggleButton_1.setBounds(0, 44, 74, 53);
				frame.getContentPane().add(tglbtnNewToggleButton_1);
				
				
				
//================================ Select Button =================================================================	 				
				JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Select");
				//Icon icon = new ImageIcon("");
				//tglbtnNewToggleButton_2.setIcon(icon);
				tglbtnNewToggleButton_2.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
					}
				});
				tglbtnNewToggleButton_2.setBounds(0, 0, 74, 51);
				frame.getContentPane().add(tglbtnNewToggleButton_2);
//================================================================================================================					
				JButton btnNewButton = new JButton("Color");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JColorChooser jcc = new JColorChooser();
						sc = jcc.showDialog(null, "Select a color", Color.black);
					}
				});
				btnNewButton.setBounds(73, 0, 99, 45);
				frame.getContentPane().add(btnNewButton);
				
				JButton btnFillColor = new JButton("Fill Color");
				btnFillColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JColorChooser jcc2 = new JColorChooser();
						fc = jcc2.showDialog(null, "Select a color", Color.black);
					}
				});
				btnFillColor.setBounds(167, 0, 99, 45);
				frame.getContentPane().add(btnFillColor);
				
				JToggleButton tglbtnNewToggleButton_3 = new JToggleButton("Circle");
				tglbtnNewToggleButton_3.addChangeListener(new ChangeListener() {
					
					public void stateChanged(ChangeEvent e) {	
						
						if( tglbtnNewToggleButton_3.isSelected())
						{
							 canvas.addMouseListener(new MouseAdapter() {				
								   public void mouseClicked(MouseEvent me){
									   int x,y;
								    x = me.getX(); 
								    y = me.getY();
									Shape c = new Circle();
									HashMap<String, Double > hm = new HashMap<>();
									hm.put("1", 50.0);
									hm.put("2", 50.0);
									double l=hm.get("1"),w=hm.get("2");
									c.setPosition(new Point(x-(int)(l/2),y-(int)(w/2)));
									c.setProperties(hm);
									c.setColor(Color.black);
									c.setFillColor(Color.green);
									GUI.this.x.addShape(c);
									canvas.repaint();
									
									
								   }
								  });
						}
						else
						{
							MouseListener[] mouseListeners = canvas.getMouseListeners();
							for (MouseListener mouseListener : mouseListeners) {
							   canvas.removeMouseListener(mouseListener);
						}
						}			
					}
				});
				frame.getContentPane().setLayout(null);
				tglbtnNewToggleButton_3.setBounds(0, 194, 74, 45);
				frame.setBounds(0, 0, 1000, 614);
				frame.getContentPane().add(tglbtnNewToggleButton_3);
				
				JToggleButton tglbtnNewToggleButton_4 = new JToggleButton("Square");
				tglbtnNewToggleButton_4.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {		
						if( tglbtnNewToggleButton_4.isSelected())
						{
							 canvas.addMouseListener(new MouseAdapter() {				
								   public void mouseClicked(MouseEvent me){
									   int x,y;
								    x = me.getX(); 
								    y = me.getY();
									Shape s = new Square();
									HashMap<String, Double > hm = new HashMap<>();
									hm.put("1", 50.0);
									hm.put("2", 50.0);
									double l=hm.get("1"),w=hm.get("2");
									s.setPosition(new Point(x-(int)(l/2),y-(int)(w/2)));
									s.setProperties(hm);
									s.setColor(Color.black);
									s.setFillColor(Color.green);
									GUI.this.x.addShape(s);
									canvas.repaint();
									
								   }
								  });
						}
						else
						{
							MouseListener[] mouseListeners = canvas.getMouseListeners();
							for (MouseListener mouseListener : mouseListeners) {
							   canvas.removeMouseListener(mouseListener);
						}
						}			
					}
				});
				frame.getContentPane().setLayout(null);
				frame.getContentPane().add(tglbtnNewToggleButton_4);
				tglbtnNewToggleButton_4.setBounds(0, 235, 74, 45);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				JToggleButton tglbtnNewToggleButton_5 = new JToggleButton("Rectangle");
				tglbtnNewToggleButton_5.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {		
						if( tglbtnNewToggleButton_5.isSelected())
						{
							 canvas.addMouseListener(new MouseAdapter() {				
								   public void mouseClicked(MouseEvent me){
									   int x,y;
								    x = me.getX(); 
								    y = me.getY();
									Shape r = new Square();
									HashMap<String, Double > hm = new HashMap<>();
									hm.put("1", 50.0);
									hm.put("2", 100.0);
									double l=hm.get("1"),w=hm.get("2");
									r.setPosition(new Point(x-(int)(l/2),y-(int)(w/2)));
									r.setProperties(hm);
									r.setColor(Color.black);
									r.setFillColor(Color.green);
									GUI.this.x.addShape(r);
									canvas.repaint();
									
								    
									    canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
									    canvas.setBackground(Color.white);
									    frame.setContentPane(canvas);
									    
								
								   }
								  });
						}
						else
						{
							
							MouseListener[] mouseListeners = canvas.getMouseListeners();
							for (MouseListener mouseListener : mouseListeners) {
							   canvas.removeMouseListener(mouseListener);
						}
							
						
						}
						
					}
				});
				frame.getContentPane().setLayout(null);
				tglbtnNewToggleButton_5.setBounds(0, 279, 74, 38);
				frame.getContentPane().add(tglbtnNewToggleButton_5);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
//================================================================================================================	 	
	}// of initialize method

	//================================================================================================================		
	   private class DrawCanvas extends JPanel {
		      @Override
		      protected void paintComponent(Graphics g) { // called back via repaint()
		         super.paintComponent(g);
//		         int c=0;
		         for( Shape y :x.getShapes() )
		         {
		        	 y.draw(g);
//		        	 c++;
//		        	 System.out.println(c);
		         }
		      }
		   }
}
