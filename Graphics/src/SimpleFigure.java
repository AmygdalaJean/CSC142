/*
 * Ben Rockhold
 * CSC 142 -- Assignment #2
 * October 2015
 * No rights reserved
 */

import java.awt.Color;
import java.awt.Graphics;

public class SimpleFigure {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(1200,800);
		Graphics g = panel.getGraphics();
		// Draw a boring rectangle and ovoid!
		boring(g, 250, 250);
		// But wait, there's more!
		wait(10);
		whiteOut(g,1200,800); // Clear screen
		// Draw some little puffballs
		multiPoof(g);
		wait(10);
		// FILL THE SCREEN WITH PUFF
		poof(g, 100000, 1200, 600, 400);
	}
	public static void boring(Graphics g, int x, int y){
		// Pretty boring! Just draw a rectangle, oval, and line.
		// Then wait...
		g.setColor(Color.BLUE);
		g.fillRect(x, y, x+100, y+100);
		g.setColor(Color.RED);
		g.fillOval(x, y, x/2, y/2);
		g.setColor(Color.GREEN);
		g.drawLine(x, y, x+200, y+200);
	}
	public static void whiteOut(Graphics g, int x, int y){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, x, y);
	}
	public static void multiPoof(Graphics g){
		// Exercises the poof function. Not parametric at all :(
		poof(g, 3,    20,  50,   50);
		poof(g, 3,   100, 150,  150);
		poof(g, 10,  200, 500,  200);
		poof(g, 50,  200, 200,  600);
		poof(g, 5,   100, 600,  600);
		poof(g, 5,   100, 900,  125);
		poof(g, 5,    75, 150,  325);
		poof(g, 100, 200, 900,  500);
	}
	public static void poof(Graphics g, int loops, int radius, int x_offset, int y_offset) {
		/* 
		 * Arguments:
		 * 	Graphics object to draw on
		 * 	Number of times to draw a line from each point
		 * 	X-offset to apply
		 * 	Y-offset to apply
		 */
		for(int loopCount = 1; loopCount <= loops; loopCount++){
			// Build a new random color. It's usually pretty dark.
			Color loopColor = new Color(
					(int)(100*Math.random()), // R
					(int)(100*Math.random()), // G
					(int)(100*Math.random()), // B
					(int)(75*Math.random())   // Alpha
					);
			g.setColor(loopColor);
			// The point to draw _to_. Assigned prior to the loop so they all go to the same place
			int x_coord = (int)(radius*Math.cos(360*Math.random()*Math.PI/180))+x_offset;
			int y_coord = (int)(radius*Math.cos(360*Math.random()*Math.PI/180))+y_offset;
			// Draw points from every 30º point on a circle
			for(int x = 0; x <= 360; x+=20){
				// Draw a line from each point on the outside of the circle to the location
				g.drawLine(x_offset+(int)(radius*Math.cos(x*Math.PI/180)), 
							y_offset+(int)(radius*Math.sin(x*Math.PI/180)), 
							x_coord, 
							y_coord);
			}
		}	
	}
	public static void wait(int time){
		// Utility function; causes the thread to sleep for ____ seconds
		try {
			Thread.sleep((long)time*1000);
		} catch (InterruptedException e) { 
			// This probably won't happen
			e.printStackTrace();
		}
	}
}