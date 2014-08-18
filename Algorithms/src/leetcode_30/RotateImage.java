package leetcode_30;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length;
		int[][] result = new int[size][];
        for (int i = 0; i < size; ++i) {
        	result[i] = new int[size];
        }
        
        for (int i = 0; i < size; ++i) {
        	for (int j = 0; j < size; ++j) {
        		result[size - 1 - j][size - 1 - i] = matrix[i][size - 1 - j];
        	}
        }
        
        for (int i = 0; i < size; ++i) {
        	for (int j = 0; j < size; ++j) {
        		matrix[i][j] = result[i][j];
        	}
        }
    }
    
    
    //in place
    public void rotate2(int[][] matrix) {
    	flipUpToDown(matrix);
    	foldAlongTheDiagnoal(matrix);
    	
    }
	private void foldAlongTheDiagnoal(int[][] matrix) {
		int size = matrix.length;
		for (int i = 0; i < size; ++i) {
			for (int j = i + 1; j < size; ++j) {
				swap(matrix, i, j, j, i);
			}
		}
	}
	private void flipUpToDown(int[][] matrix) {
		int size = matrix.length;
    	int i = 0, j = size - 1;
    	while (i < j) {
    		for (int k = 0; k < size; ++k) {
    			swap(matrix, i, k, j, k);
    		}
    		++i;
    		--j;
    	}
	}
	private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
		int temp = matrix[i1][j1];
		matrix[i1][j1] = matrix[i2][j2];
		matrix[i2][j2] = temp;
	}
}

