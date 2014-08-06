package leetcode;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
    	if (n == 0 || n == 1) return 1; 
    	int[] result = new int[n + 1];
    	result[0] = 1;
    	result[1] = 1;
    	for (int i = 2; i <= n; ++i) {
    		int sum = 0;
    		for (int j = 0; j <= i - 1; ++j) {
    			sum += result[j] * result[i - j -1];
    		}
    		result[i] = sum;
    	}
        return result[n];
    }
}
