package leetcode_20;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int rows = obstacleGrid.length;
    	int columns = obstacleGrid[0].length;
		int[][] result = new int[rows][];
		for (int i = 0; i < result.length; ++i) {
    		result[i] = new int[columns];
    	}
		if (obstacleGrid[0][0] == 1) result[0][0] = 0;
		else result[0][0] = 1;
    	for (int i = 1; i < columns; ++i) {
    		if (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 0 && result[0][i - 1] == 1) {
    			result[0][i] = 1;
    		} else {
    			result[0][i] = 0;
    		}
    	}
    	for (int i = 1; i < rows; ++i) {
    		if (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 0 && result[i - 1][0] == 1) {
    			result[i][0] = 1;
    		} else {
    			result[i][0] = 0;
    		}
    	}
    	
    	for (int i = 1; i < rows; ++i) {
    		for (int j = 1; j < columns; ++j) {
    			if (obstacleGrid[i][j] == 1) {
    				result[i][j] = 0;
    			} else {
    				result[i][j] = result[i - 1][j] + result[i][j - 1];
    			}
    		}
    	}
        return result[rows - 1][columns - 1];
    }
}
