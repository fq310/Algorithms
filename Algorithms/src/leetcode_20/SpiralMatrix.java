package leetcode_20;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        int startX = 0, startY = 0, endX = matrix.length - 1, endY = matrix[0].length - 1;
        while (startX <= endX && startY <= endY) {
        	if (endX == startX) {
        		addRow(matrix, startX, startY, endY, result);
        		break;
        	}
        	if (startY == endY) {
        		addColumn(matrix, startY, startX, endX, result);
        		break;
        	}
        	int x = startX, y = startY;
        	while (y <= endY) {
        		result.add(matrix[x][y++]);
        	}
        	--y; ++x;
        	while (x <= endX) {
        		result.add(matrix[x++][y]);
        	}
        	--x; --y;
        	while (y >= startY) {
        		result.add(matrix[x][y--]);
        	}
        	++y; --x;
        	while (x > startX) {
        		result.add(matrix[x--][y]);
        	}
        	++startX; ++startY;
        	--endX; --endY;
        }
        return result;
    }

	private void addColumn(int[][] matrix, int y, int startX, int endX,
			List<Integer> result) {
		for (int i = startX; i <= endX; ++i) {
			result.add(matrix[i][y]);
		}
	}

	private void addRow(int[][] matrix,
			int x, int startY, int endY, List<Integer> result) {
		for (int i = startY; i <= endY; ++i) {
			result.add(matrix[x][i]);
		}
	}

}
