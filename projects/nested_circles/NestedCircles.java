public class NestedCircles {

    // draw a circle with some embellishments
    // the center is (x, y) with the specified radius
    public static void fancyCircle(double x, double y, double radius) {

        // equally likely 0 or 1
        int randomBit = StdRandom.uniform(2);

        // pick circle color
        if (randomBit == 0)
            StdDraw.setPenColor(StdDraw.CYAN);
        else
            StdDraw.setPenColor(StdDraw.YELLOW);

        // draw circle
        StdDraw.filledCircle(x, y, radius);

        // draws gray outline around each circle
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.circle(x, y, radius);
    }

    // draw a nested circle of order n, centred at (x, y) with
    // the specified radius
    public static void draw(int n, double x, double y, double radius) {
        if (n == 0) {  // base case
            return;
        }

        // recursive case
        fancyCircle(x, y, radius);

        // draw two nested circles of order n-1
        double halfRadius = radius / 2;

        draw(n - 1, x - halfRadius, y, halfRadius);
        draw(n - 1, x + halfRadius, y, halfRadius);
    }

    // takes an integer command-line argument n
    // and plots an order n circle
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5; // biggest circle centred at (0.5, 0.5)
        draw(n, x, y, 0.5);      // radius fills up [0,1] x [0,1] view
    }
}
