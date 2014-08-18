package leetcode_30;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] num) {
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> numbers = new ArrayList<>();
    	for (int i : num) {
    		numbers.add(i);
    	}
    	permutation(new ArrayList<Integer>(), numbers, result);
    	return result;
    }

	private void permutation(List<Integer> sortedNumber, List<Integer> restNumber, List<List<Integer>> result) {
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

	
	//general version based on string
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}


