package eg.edu.alexu.csd.oop.draw;

import java.awt.Graphics;
import java.awt.Point;

public class LineSegment extends Shape{
	public Point p=getPosition();
	
	
	
     
	
	  public void draw(Graphics canvas) {
		  canvas.drawLine((int)Math.round(properties.get("1")),(int)Math.round(properties.get("2")) ,(int)Math.round(2*p.x-properties.get("1")) , (int)Math.round(2*p.x-properties.get("2")));}
	    @Override
		public void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
	    	super.paintComponent(g);
			this.draw(g);
		}
    
}
