
public class Fast {
    
    private static class PointWithSlope implements Comparable<PointWithSlope> {
        private Point point;
        private double slope;
        public PointWithSlope(Point point, double slope) {
            this.point = point;
            this.slope = slope;
        }
        public Point getPoint() {
            return point;
        }
        public double getSlope() {
            return slope;
        }
        
        @Override
        public int compareTo(PointWithSlope o) {
            return Double.compare(slope, o.slope);
        }
    }
    
    private static String[] drawedLine;
    private static int drawIndex = 0;

    /**
     * @param args
     */
    public static void main(String[] args) {
        String fileName = args[0];
        In fileInput = new In(fileName);
        int[] data = fileInput.readAllInts();
        int pointCount = data[0];
        drawedLine = new String[pointCount];
        Point[] points = new Point[pointCount];
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        int pointIndex = 0;
        for (int i = 1; i < data.length; i = i + 2) {
            Point point = new Point(data[i], data[i + 1]);
            points[pointIndex++] = point; 
            point.draw();
        }

        for (int i = 0; i < pointCount; ++i) {
            int originPoint = i;
            PointWithSlope[] slopes = new PointWithSlope[pointCount];
            for (int j = 0; j < pointCount; ++j) {
                double slope = points[originPoint].slopeTo(points[j]);
                PointWithSlope p = new PointWithSlope(points[j], slope);
                slopes[j] = p;
            }
            Quick.sort(slopes);
            Point[] linePoints = new Point[pointCount];
            linePoints[0] = points[originPoint];
            int linePointsCount = 1;
            for (int j = 0; j < pointCount - 1; ++j) {
                if (slopes[j].getSlope() == slopes[j + 1].getSlope()) {
                    linePoints[linePointsCount++] = slopes[j].getPoint();
                    continue;
                } else {
                    if (linePointsCount >= 3) {
                        linePoints[linePointsCount++] = slopes[j].getPoint();
                        String line = getLine(linePoints, linePointsCount);
                        if (notDrawed(line)) {
                            StdOut.println(line);
                            linePoints[0].drawTo(linePoints[linePointsCount - 1]);
                            addLine(line);
                        }
                    }
                    linePoints[0] = points[originPoint];
                    linePointsCount = 1;
                }
            }
            if (linePointsCount >= 3) {
                String line = getLine(linePoints, linePointsCount);
                if (notDrawed(line)) {
                    StdOut.println(getLine(linePoints, linePointsCount));
                    linePoints[0].drawTo(linePoints[linePointsCount - 1]);
                    addLine(line);
                }
            }
        }
    }

    private static void addLine(String newLine) {
        if (drawIndex >= drawedLine.length) {
            String[] temp = new String[drawIndex*2];
            for (int i = 0; i < drawedLine.length; ++i) {
                temp[i] = drawedLine[i];
            }
            drawedLine = temp;
        }
        drawedLine[drawIndex++] = newLine;
    }

    private static boolean notDrawed(String newLine) {
        for (String line : drawedLine) {
            if (line == null) break;
            if (line.equals(newLine) || line.contains(newLine)) return false;
        }
        return true;
    }

    private static String getLine(Point[] linePoints, int linePointsCount) {
        Point[] points = new Point[linePointsCount];
        for (int i = 0; i < linePointsCount; ++i) {
            points[i] = linePoints[i];
        }
        Quick.sort(points);
        String arrow = " -> ";
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < points.length; ++i) {
            result.append(arrow).append(points[i]);
        }
        result.insert(0, points[0]);
        return result.toString();
    }
}
