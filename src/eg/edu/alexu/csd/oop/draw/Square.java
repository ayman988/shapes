package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

import javax.swing.JPanel;

public class Square  extends Shape {
	private double length, width;
	 public void setProperties(Map<String, Double> properties) {
		 length=properties.get("1");
		 width=properties.get("2");
	 }
	   
	    public void draw(Graphics canvas) {
			  canvas.fillRect(getPosition().x, getPosition().y,(int)length,(int)width);
			
		    }
		    @Override
			public void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
		    	super.paintComponent(g);
				this.draw(g);
			}
	    
}
