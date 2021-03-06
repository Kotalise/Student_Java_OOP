import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    public static final int MAX_ITERATIONS = 2000;

    public void getInitialRange(Rectangle2D.Double range) {
        // Method allows the fractal generator to determine the area
        range.x = -2;
        range.y = -1.5;

        range.width = 3;
        range.height = 3;
    }

    public int numIterations(double x, double y) {
        //Function for a fractal
        int count = 0;

        double re = 0;
        double im = 0;
        double z_n2 = 0;

        while (count < MAX_ITERATIONS && z_n2 < 4) {
            count++;

            double nextRe = re*re - im*im + x;
            double nextIm = 2 * re * im + y;

            z_n2 = nextRe*nextRe + nextIm*nextIm;

            re = nextRe;
            im = nextIm;
        }

        return count < MAX_ITERATIONS ? count : -1;
    }
}