package leetcode_20;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
    	int rowHeight[] = new int[matrix[0].length];
    	int maxArea = 0;
    	for (int i = 0; i < matrix.length; ++i) {
    		for (int j = 0; j < matrix[i].length; ++j) {
    			if (matrix[i][j] == '1') {
    				rowHeight[j] += 1;
    			} else {
    				rowHeight[j] = 0;
    			}
    		}
    		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
    		maxArea = Math.max(maxArea, l.largestRectangleArea(rowHeight));
    	}
    	return maxArea;
    }
}
