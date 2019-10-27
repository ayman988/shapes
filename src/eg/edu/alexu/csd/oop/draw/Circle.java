package eg.edu.alexu.csd.oop.draw;
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
public class Circle extends Shape  {
	 private double radius;
	public double getRadius(){return properties.get("1");}
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub
		radius=properties.get("1");
	} 
	
	
	  public void draw(Graphics canvas) {
		  canvas.setColor(getFillColor());
		  canvas.fillOval(getPosition().x, getPosition().y,(int)radius,(int)radius);
		  
	    }
	    @Override
		public void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
	    	super.paintComponent(g);
			this.draw(g);
		}
    
}
