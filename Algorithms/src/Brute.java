
public class Brute {

     private static String[] drawedLines;
     private static int drawedLinesNum = 0;
    /**
     * @param args
     */
    public static void main(String[] args) {
        String fileName = args[0];
        In fileInput = new In(fileName);
        int[] data = fileInput.readAllInts();
        int pointCount = data[0];
        drawedLines = new String[pointCount];
        Point[] points = new Point[pointCount];
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        int j = 0;
        for (int i = 1; i < data.length; i = i + 2) {
            Point point = new Point(data[i], data[i + 1]);
            points[j++] = point;
            point.draw();
        }
        
        String[] lines = new String[pointCount];
        int linesCount = 0;
       
        int n, m, k, l;
        int len = points.length;
        String arrow = " -> ";
        for (n = 0; n < len - 3; n++) {
            for (m = n + 1; m < len - 2; m++) {
                for (k = m + 1; k < len - 1; k++) {
                    for (l = k + 1; l < len; ++l) {
                        double slope1 = points[n].slopeTo(points[m]);
                        double slope2 = points[m].slopeTo(points[k]);
                        double slope3 = points[k].slopeTo(points[l]);
                        if (slope1 == slope2 && slope2 == slope3) {
                            Point[] fourPoints = new Point[4];
                            fourPoints[0] = points[n];
                            fourPoints[1] = points[m];
                            fourPoints[2] = points[k];
                            fourPoints[3] = points[l];
                            Quick.sort(fourPoints);
                            StringBuilder result = new StringBuilder();
                            result.append(fourPoints[0] + arrow);
                            result.append(fourPoints[1] + arrow);
                            result.append(fourPoints[2] + arrow);
                            result.append(fourPoints[3]);
                            String line = result.toString();
                            boolean existed = false;
                            for (int i = 0; i < lines.length; ++i) {
                                if (lines[i] == null) break;
                                if (lines[i].equals(line)) {
                                    existed = true;
                                    break;
                                }
                            }
                            if (existed == true) continue;
                            StdOut.println(line);
                            if (linesCount >= lines.length) {
                                String[] temp = new String[lines.length*2];
                                for (int i = 0; i < lines.length; ++i) {
                                    temp[i] = lines[i];
                                }
                                lines = temp;
                            }
                            lines[linesCount++] = line;
                            
                            
                           draw(fourPoints[0], fourPoints[1]);
                           draw(fourPoints[1], fourPoints[2]);
                           draw(fourPoints[2], fourPoints[3]);
                        }
                    }
                }
                    
            }
        }
    }
    
    private static void draw(Point point1, Point point2) {
         boolean drawed = false;
         String drawLine = point1.toString() + point2.toString();
         for (int i = 0; i < drawedLines.length; ++i) {
             String drawedLine = drawedLines[i];
             if (drawedLine == null) break;
             if (drawedLine.equals(drawLine)) {
                 drawed = true;
                 break;
             }
         }
         if (drawed == false) {
             point1.drawTo(point2);
             if (drawedLinesNum >= drawedLines.length) {
                 String[] temp = new String[drawedLines.length*2];
                 for (int i = 0; i < drawedLines.length; ++i) {
                     temp[i] = drawedLines[i];
                 }
                 drawedLines = temp;
             }
             drawedLines[drawedLinesNum] = drawLine;
             drawedLinesNum++;
         }
    }

}
