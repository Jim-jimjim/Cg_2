import java.awt.*;

public class Triangle {

    public int[] cordX = {0, 100, 50};
    public int[] cordY = {0, 0, 100};
    public int n = cordX.length;

    public Polygon draw() {
        return new Polygon(cordX, cordY, 3);
    }
}
