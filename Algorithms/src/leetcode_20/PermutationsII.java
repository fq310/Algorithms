package leetcode_20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
    	Set<List<Integer>> result = new HashSet<>();
    	List<Integer> numbers = new ArrayList<>();
    	for (int i : num) {
    		numbers.add(i);
    	}
    	permutation(new ArrayList<Integer>(), numbers, result);
    	return new ArrayList<>(result);
    }

	private void permutation(List<Integer> sortedNumber, List<Integer> restNumber, Set<List<Integer>> result) {
		int size = restNumber.size();
		if (size == 0) {
			result.add(sortedNumber);
		} else {
			for (int i = 0; i < size; ++i) {
				Integer currentNumber = restNumber.get(i);
				ArrayList<Integer> newSortedNumber = new ArrayList<>(sortedNumber);
				newSortedNumber.add(currentNumber);
				ArrayList<Integer> newRestNumber = new ArrayList<>(restNumber);
				newRestNumber.remove(currentNumber);
				permutation(newSortedNumber, newRestNumber, result);
			}
		}
	}
}
