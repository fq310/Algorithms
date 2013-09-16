import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new BySlope(this);       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        if (x == that.x && y != that.y) {
            return Double.POSITIVE_INFINITY;
        }
        if (y == that.y && x != that.x) {
            return +0.0;
        }
        if (x == that.x && y == that.y) {
            return Double.NEGATIVE_INFINITY;
        }
        return ((double) (that.y - y)) / ((double) (that.x - x));
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if (y < that.y || (y == that.y && x < that.x)) {
            return -1;
        }
        if (y == that.y && x == that.x) return 0;
        return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
    
    private static class BySlope implements Comparator<Point> {
        private Point point;

        public BySlope(Point point) {
            this.point = point;
        }

        @Override
        public int compare(Point a, Point b) {
            double slopeA = point.slopeTo(a);
            double slopeB = point.slopeTo(b);
            if (slopeA < slopeB) return -1;
            if (slopeA == slopeB) return 0;
            return 1;
        }
    }
}
