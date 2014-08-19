package leetcode_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _3Sum {
    public List<List<Integer>> threeSum(int[] num) {
    	Arrays.sort(num);
    	List<List<Integer>> result = new ArrayList<>();
    	for (int i = 0; i < num.length - 2; ++i) {
    		if (i > 0 && num[i] == num[i - 1]) continue;
    		int low = i + 1, high = num.length - 1;
    		while (low < high) {
    			int value =num[i] + num[low] + num[high];
    			if (value == 0) {
    				List<Integer> solution = new ArrayList<>();
    				solution.add(num[i]);
    				solution.add(num[low]);
    				solution.add(num[high]);
    				result.add(solution);
    			}
    			if (value < 0) {
    				++low;
    			} else {
    				--high;
    			}
    		}
    	}
    	Set<List<Integer>> set = new HashSet<>();
    	set.addAll(result);
    	return new ArrayList<>(set);
    }
}
