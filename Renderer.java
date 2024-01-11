import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Renderer extends JFrame {
    private int windowWidth, windowHeight;
    private JPanel panel;

    public Renderer(int windowWidth, int windowHeight) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }

    public boolean Setup() {
        // Create JPanel with set dimensions
        panel = new JPanel();
        getContentPane().add(panel);
        setSize(windowWidth, windowWidth);

        return true;
    }
    
    public void ClearScreen() {

    }
    public void Render() {

    }

    public void DrawLine(Graphics g, int x0, int y0, int x1, int y1, String color) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.decode(color));
        g2.drawLine(x0, y0, x1, y1);
    }

    public void DrawPoint(Graphics g, int x, int y, String color) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.decode(color));
        g2.drawLine(x, y, x, y);
    }


    // Getters for windowHeight and windowWidth
    public int GetWindowHeight() {
        return this.windowHeight;
    }
    public int GetWindowWidth() {
        return this.windowWidth;
    }
}
