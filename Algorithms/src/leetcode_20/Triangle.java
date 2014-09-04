package leetcode_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle.size() == 0) return 0;
    	if (triangle.get(0).size() == 0) return 0;
    	
    	int sum = triangle.get(0).get(0);
    	List<List<Integer>> results = new ArrayList<>();
    	List<Integer> result0 = new ArrayList<>();
    	result0.add(sum);
    	results.add(result0);
    	for (int i = 0; i < triangle.size() - 1; ++i) {
    		List<Integer> row = triangle.get(i);
    		List<Integer> nextRow = triangle.get(i + 1);
    		for (int j = 0; j < row.size(); ++j) {
    			Integer left = nextRow.get(j);
        		Integer right = nextRow.get(j + 1);
    			List<Integer> result;
    			if (i + 1 > results.size() - 1) {
    				result = new ArrayList<>();
    				results.add(result);
    			} else {
    				result = results.get(i + 1);
    			}
    			int parentSum = results.get(i).get(j);
    			left += parentSum;
    			if (j > result.size() - 1) {
    				result.add(left);
    			} else {
    				result.set(j, Math.min(left, result.get(j)));
    			}
    			right += parentSum;
    			if (j + 1 > result.size() - 1) {
    				result.add(right);
    			} else {
    				result.set(j + 1, Math.min(result.get(j + 1), right));
    			}
    		}
    	}
    	List<Integer> lastRow = results.get(results.size() - 1);
    	Collections.sort(lastRow);
        return lastRow.get(0);
    }
}
