import java.awt.*;

public class ShowDesign {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(110, 110);
        Graphics g = panel.getGraphics();
        for (int i = 1; i <= 10; i++) {
            g.drawRect(10-5, 10*i-5, 10*i, 10);
        }
    }
}