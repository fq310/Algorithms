package leetcode_30;

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
    	int[] sum = new int[A.length];
    	sum[0] = A[0];
    	int max = A[0];
    	for (int i = 1; i < A.length; ++i) {
    		sum[i] = max(A[i] + sum[i - 1], A[i]);
    		max = max(sum[i], max);
    	}
        return max;
    }
	private int max(int i, int j) {
		return i > j ? i : j; 
	}
    
}
