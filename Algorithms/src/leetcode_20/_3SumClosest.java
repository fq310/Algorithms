package leetcode_20;

import java.util.Arrays;

public class _3SumClosest {
    public int threeSumClosest(int[] num, int target) {
    	Arrays.sort(num);
    	int closest = num[0] + num[1] + num[2];
    	for (int i = 0; i < num.length - 2; ++i) {
    		if (i > 0 && num[i] == num[i - 1]) continue;
    		int low = i + 1, high = num.length - 1;
    		while (low < high) {
    			int value = num[i] + num[low] + num[high];
    			if (Math.abs(value - target) < Math.abs(closest - target)) {
    				closest = value;
    			}
    			if (value > target) {
    				--high;
    			} else {
    				++low;
    			}
    		}
    	}
        return closest;
    }
}
