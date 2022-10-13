import org.ejml.simple.SimpleMatrix;

public class Aff {
    //RealMatrix matrix = new Array2DRowRealMatrix(new double[][]{{0,1}, {1, 0}});
    private static int[] tr0 = {0, 0};

    public static void rotate(Triangle shape, double theta) {
        SimpleMatrix matrix = new SimpleMatrix(new double[][]{{Math.cos(theta), Math.sin(theta), 0},
                {-Math.sin(theta), Math.cos(theta), 0},
                {0, 0, 1}});
        work(shape, matrix);
    }

    public static void mas(Triangle shape, double t) {
        SimpleMatrix matrix = new SimpleMatrix(new double[][]{{t, 0, 0},
                {0, t, 0},
                {0, 0, 1}});
        work(shape, matrix);
    }

    public static void perm(Triangle shape, double x, double y) {
        SimpleMatrix matrix = new SimpleMatrix(new double[][]{{1, 0, 0},
                {0, 1, 0},
                {x, y, 1}});
        work(shape, matrix);
    }

    public static void ras(Triangle shape, double x, double y) {
        SimpleMatrix matrix = new SimpleMatrix(new double[][]{{x == 0 ? 1 : x, 0, 0},
                {0, y == 0 ? 1 : y, 0},
                {0, 0, 1}});
        work(shape, matrix);
    }

    public static void tt(double x, double y) {
        tr0[0] = (int) x;
        tr0[1] = (int) y;
    }

    private static void work(Triangle shape, SimpleMatrix matrix) {
        int[] tempX = shape.cordX;
        int[] tempY = shape.cordY;
        for (int i = 0; i < shape.n; i++) {
            SimpleMatrix temp = new SimpleMatrix(new double[][]{{tempX[i] - tr0[0], tempY[i] - tr0[1], 1}});
            temp = temp.mult(matrix);
            shape.cordX[i] = (int) temp.get(0, 0) + tr0[0];
            shape.cordY[i] = (int) temp.get(0, 1) + tr0[1];
        }
    }
}
