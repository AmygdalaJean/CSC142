import java.awt.*;

public class drawWindow{
	public static void main(String[] args){
		DrawingPanel panel = new DrawingPanel(520,240);
		Graphics g = panel.getGraphics();
		books(g, 400,0, 100,100);
		books(g, 0,0, 35,35);
		books(g, 200,0, 60,60);
		
	}
	
	// Nonfunctional incomlete book-stack-drawer
	public static void books(Graphics g, int x_offset, int y_offset, int x_size, int y_size) {       
		// Draw a cyan rectangle
		g.setColor(Color.CYAN);
        g.fillRect(x_offset, y_offset, x_size, y_size);
        
        // Draw brown stairs on top of the cyan rectangle
        g.setColor(Color.BLUE);
        for(int row = 0; row <= x_size; row+=y_size/10){
        	g.fillRect(x_offset, row+y_offset, row, 9);
        }

	}
	
	

}
