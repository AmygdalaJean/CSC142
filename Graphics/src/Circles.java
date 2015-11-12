/*
 * Ben Rockhold
 * CSC 142 -- Assignment #2
 * October 2015
 * No rights reserved
 */

import java.awt.Color;
import java.awt.Graphics;

public class Circles {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(400,425);
		Graphics drawing = panel.getGraphics();
		// Set up the background
		drawing.setColor(Color.CYAN);
		drawing.fillRect(0, 0, 500, 500);
		// Mutiple calls of multiCircle to draw patterns to the screen
		//					 X,    Y,Row,Col,Size,Circles
		multiCircle(drawing, 0,     0, 1, 1, 100, 10);
		multiCircle(drawing, 18,  175, 6, 6,  24,  4);
		multiCircle(drawing, 180,  25, 5, 5,  40,  5);
		multiCircle(drawing, 180, 250, 4, 4,  36,  6);
	}
	public static void multiCircle(Graphics g, int x_offset, int y_offset, int rows, int cols, int size, int circles){
		// Multiplies the fancyCircle method
		// Generates an array X*Y of a given size, and with an (x,y) offset
		for(int r = 0; r<rows; r++){
			for(int c = 0; c<cols; c++){
				fancyCircle(g,size,x_offset+r*size,y_offset+c*size,circles);
			}
		}
	}
	public static void fancyCircle(Graphics g, int width, int x_offset, int y_offset, int circles){
		// Draw concentric yellow circles on top of a green rectangle, crossed with black lines.
		// User defines size, position (x,y), and number of circles.
		g.setColor(Color.GREEN);
		g.fillRect(x_offset, y_offset, width, width);
		g.setColor(Color.YELLOW);
		g.fillOval(x_offset, y_offset, width, width);
		g.setColor(Color.BLACK);
		g.drawRect(x_offset, y_offset, width, width);
		for(int count = 1; count <= circles; count++){
			int x = x_offset+(width/2)-(count*width/circles/2);
			int y = y_offset+(width/2)-(count*width/circles/2);
			g.drawOval(x, y, width/circles*count, width/circles*count);
		}
		g.drawLine(x_offset, y_offset, width+x_offset, width+y_offset); // Top left to bottom right
		g.drawLine(x_offset, y_offset+width, x_offset+width, y_offset); // Bottom left to top right
		g.drawLine(x_offset+width/2, y_offset, x_offset+width/2, width+y_offset); // Top center to bottom
		g.drawLine(x_offset, y_offset+width/2, width+x_offset, y_offset+width/2); // Left to right
	}
}
