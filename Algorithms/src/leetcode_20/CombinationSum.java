package leetcode_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Set<List<Integer>> result = new HashSet<>();
    	calculate(candidates, 0, target, new ArrayList<Integer>(), result);
    	return new ArrayList<List<Integer>>(result);
    }

	private void calculate(int[] candidates, int sum, int target,
			List<Integer> solution, Set<List<Integer>> result) {
		if (sum > target) return;
		if (sum == target) {
			Collections.sort(solution);
			result.add(solution);
		}
		for (int i = 0; i < candidates.length; ++i) {
			sum += candidates[i];
			ArrayList<Integer> newSolution = new ArrayList<>(solution);
			newSolution.add(candidates[i]);
			calculate(candidates, sum, target, newSolution, result);
			sum -= candidates[i];
		}
	}
}
