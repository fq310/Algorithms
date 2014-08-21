package leetcode_20;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
    	if (isValidRowAndColumn(board) == false) return false;
    	for (int i = 0; i < 9; i += 3) {
    		for (int j = 0; j < 9; j += 3) {
    			if (isSingleMatrix(board, i, j, 3) == false) return false;
    		}
    	}
        return true;
    }
    
    private boolean isSingleMatrix(char[][] matrix, int x, int y, int size) {
    	int[] testDataArray = initialTestArray();
    	int rowSize = x + size;
    	int colSize = y + size;
    	for (int i = x; i < rowSize; ++i) {
    		for (int j = y; j < colSize; ++j) {
    			char c = matrix[i][j];
    			if (c < '1' || c > '9') continue;
    			if (testDataArray[c - '1'] != 0) return false;
    			else testDataArray[c - '1'] = 1;
    		}
    	}
		return true;
	}

	private boolean isValidRowAndColumn(char[][] matrix) {
    	for (int i = 0; i < matrix.length; ++i) {
    		int[] testDataArray = initialTestArray();
    		char[] row = matrix[i];
    		for (char c : row) {
    			if (c < '1' || c > '9') continue;
    			if (testDataArray[c - '1'] != 0) return false;
    			else testDataArray[c - '1'] = 1;
    		}
    	}
    	for (int i = 0; i < matrix[0].length; ++i) {
    		int[] testDataArray = initialTestArray();
    		for (int j = 0; j < matrix.length; ++j) {
    			char c = matrix[j][i];
    			if (c < '1' || c > '9') continue;
    			if (testDataArray[c - '1'] != 0) return false;
    			else testDataArray[c - '1'] = 1;
    		}
    	}
        return true;
    }

	private int[] initialTestArray() {
		int[] testArray = new int[9];
    	for (int i = 0; i < testArray.length; ++i) {
    		testArray[i] = 0;
    	}
    	return testArray;
	}
}
