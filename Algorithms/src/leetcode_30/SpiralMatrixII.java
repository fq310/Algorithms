package leetcode_30;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
    	int result[][] = initialResultArray(n);
    	int start = 0, end = n - 1;
    	int count = 0;
    	while (start <= end) {
    		int i = start, j = start;
    		for (; j <= end; ++j) {
    			result[i][j] = ++count;
    		}
    		--j; ++i;
    		for (; i <= end; ++i) {
    			result[i][j] = ++count;
    		}
    		--i; --j;
    		for (; j >= start; --j) {
    			result[i][j] = ++count;
    		}
    		++j; --i;
    		for (; i > start; --i) {
    			result[i][j] = ++count;
    		}
    		++start;
    		--end;
    	}
        return result;
    }

	private int[][] initialResultArray(int n) {
		int result[][] = new int[n][];
    	for (int i = 0; i < result.length; ++i) {
    		result[i] = new int[n];
    		for (int j = 0; j < result[i].length; ++j) {
    			result[i][j] = 0;
    		}
    	}
    	return result;
	}
}
