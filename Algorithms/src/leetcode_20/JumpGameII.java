package leetcode_20;

public class JumpGameII {
    public int jump(int[] A) {
    	int end = A.length - 1;
    	int count = 0;
    	while (end > 0) {
    		for (int i = 0; i < end; ++i) {
    			if (A[i] + i >= end) {
    				++count;
    				end = i;
    			}
    		}
    	}
        return count;
    }
}
