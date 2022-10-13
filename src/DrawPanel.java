import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    public static final int[] CENTER = {300, 300};
    public Triangle triangle = new Triangle();
    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        start(g);
        g.setColor(Color.CYAN);
        g.draw(triangle.draw());
    }

    public void rotate(double theta) {
        Aff.rotate(triangle, theta * Math.PI / 180);
    }

    public void mas(double t) {
        Aff.mas(triangle, t);
    }

    public void perm(double x, double y) {
        Aff.perm(triangle, x, y);
    }

    public void ras(double x, double y) {
        Aff.ras(triangle, x, y);
    }

    public void tt(double x, double y) {
        Aff.tt(x, y);
    }
    private static void start(Graphics2D g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 1000, 1000);
        g.setColor(Color.BLACK);
        g.drawLine(300, 0, 300, 1000);
        g.drawLine(0,300,1000, 300);

        g.translate(CENTER[0], CENTER[1]);
        g.rotate(Math.PI);
        g.scale(-1,1);
    }
}
