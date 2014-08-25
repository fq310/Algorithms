package leetcode_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CombinationSumII {
	private class SingleSolution {
		int lastIndex;
		List<Integer> values = new ArrayList<>();
		int sum = 0;
		
		public SingleSolution(int index, int value) {
			lastIndex = index;
			values.add(value);
			this.sum += value;
		}
		@Override
		public String toString() {
			return String.valueOf(lastIndex) + "," + sum + "," + values.toString();
		}
	}
	
    public List<List<Integer>> combinationSum2(int[] num, int target) {
    	List<SingleSolution> solutions = new LinkedList<>();
    	Queue<SingleSolution> queue = new LinkedList<>();
    	Arrays.sort(num);
    	for (int i = 0; i < num.length; ++i) {
    		queue.add(new SingleSolution(i, num[i]));
    	}
    	while (queue.size() > 0) {
    		SingleSolution solution = queue.poll();
    		if (solution.sum == target) {
    			solutions.add(solution);
    		}
    		for (int i = solution.lastIndex + 1; i < num.length; ++i) {
    			SingleSolution newSolution = new SingleSolution(i, num[i]);
    			newSolution.values.addAll(0, solution.values);
    			newSolution.sum = solution.sum + num[i];
    			if (newSolution.sum > target) continue;
    			queue.add(newSolution);
    		}
    	}
    	Set<List<Integer>> result = new HashSet<>();
    	for (SingleSolution solution : solutions) {
    		result.add(solution.values);
    	}
    	return new ArrayList<List<Integer>>(result);
    }
}
