package leetcode_30;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
    	int result[][] = new int[grid.length][];
    	for (int i = 0; i < grid.length; ++i) {
    		result[i] = new int[grid[i].length];
    	}
    	for (int i = 0; i < grid.length; ++i) {
    		for (int j = 0; j <grid[i].length; ++j) {
    			if (i == 0 && j == 0) result[i][j] = grid[i][j];
    			else 
    				result[i][j] = min(getValue(i - 1, j, result), getValue(i, j - 1, result)) + grid[i][j];
    		}
    	}
        return result[result.length - 1][result[0].length - 1];
    }

	private int min(int value1, int value2) {
		return value1 < value2 ? value1 : value2;
	}

	private int getValue(int i, int j, int[][] minValueArray) {
		if (i < 0 || j < 0) return Integer.MAX_VALUE;
		return minValueArray[i][j];
	}
}
