package leetcode_20;

public class TrappingRainWater {
    public int trap(int[] A) {
    	int left = 0, right = A.length - 1, level = 0, blocks = 0, water = 0;
    	while (left <= right) {
    		if (Math.min(A[left], A[right]) > level) {
    			water += (Math.min(A[left], A[right]) - level) * (right - left + 1);
    			level = Math.min(A[left], A[right]);
    		}
    		if (A[left] < A[right]) {
    			blocks += A[left++];
    		} else {
    			blocks += A[right--];
    		}
    	}
        return water - blocks;
    }

}
