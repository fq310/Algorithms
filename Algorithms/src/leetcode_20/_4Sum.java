package leetcode_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _4Sum {
    public List<List<Integer>> fourSum(int[] num, int target) {
    	Arrays.sort(num);
    	List<List<Integer>> results = new ArrayList<>();
    	for (int i = 0; i < num.length - 3; ++i) {
    		List<List<Integer>> result = threeSum(num, target - num[i], i + 1);
    		for (List<Integer> list : result) {
    			list.add(0, num[i]);
    		}
    		results.addAll(result);
    	}
    	Set<List<Integer>> set = new HashSet<>();
    	set.addAll(results);
    	return new ArrayList<>(set);
    }
    
    private List<List<Integer>> threeSum(int[] num, int target, int startIndex) {
    	List<List<Integer>> result = new ArrayList<>();
    	for (int i = startIndex; i < num.length - 2; ++i) {
    		if (i > startIndex && num[i] == num[i - 1]) continue;
    		int low = i + 1, high = num.length - 1;
    		while (low < high) {
    			int value =num[i] + num[low] + num[high];
    			if (value == target) {
    				List<Integer> solution = new ArrayList<>();
    				solution.add(num[i]);
    				solution.add(num[low]);
    				solution.add(num[high]);
    				result.add(solution);
    			}
    			if (value < target) {
    				++low;
    			} else {
    				--high;
    			}
    		}
    	}
    	return result;
    }
}
