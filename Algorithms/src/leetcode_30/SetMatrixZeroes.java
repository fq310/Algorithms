package leetcode_30;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
    	boolean zeroRow[] = new boolean[matrix.length];
    	boolean zeroColumn[] = new boolean[matrix[0].length];
    	for (int i = 0; i < matrix.length; ++i) {
    		for (int j = 0; j < matrix[i].length; ++j) {
    			if (matrix[i][j] == 0) {
    				zeroRow[i] = true;
    				zeroColumn[j] = true;
    			}
    		}
    	}
    	
    	for (int i = 0; i < zeroRow.length; ++i) {
    		if (zeroRow[i] == true) {
    			for (int j = 0; j < matrix[i].length; ++j) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	for (int i = 0; i < zeroColumn.length; ++i) {
    		if (zeroColumn[i] == true) {
    			for (int j = 0; j < matrix.length; ++j) {
    				matrix[j][i] = 0;
    			}
    		}
    	}
    }
}
