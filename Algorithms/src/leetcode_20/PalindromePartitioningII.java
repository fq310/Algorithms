package leetcode_20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromePartitioningII {
    public int minCut(String s) {
    	List<List<String>> result = new ArrayList<>();
    	int[] min = new int[1];
    	Set<String> paSet = new HashSet<>();
    	search(s, new ArrayList<String>(), result, min, paSet);
    	return min[0];
    }

	private void search(String s, List<String> partitions, List<List<String>> result, int[] min, Set<String> paSet) {
		if (s.length() == 0) {
			result.add(partitions);
			if (min[0] == 0) min[0] = partitions.size() - 1;
			else min[0] = Math.min(partitions.size() - 1, min[0]);
			return;
		}
		for (int i = 0; i < s.length(); ++i) {
			String str = s.substring(0, i + 1);
			if (isPalindom(str, paSet)) {
				List<String> newPartitions = new ArrayList<>();
				newPartitions.addAll(partitions);
				newPartitions.add(str);
				search(s.substring(i + 1), newPartitions, result, min, paSet);
			}
		}
	}

	private boolean isPalindom(String str, Set<String> paSet) {
		if (paSet.contains(str)) return true;
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) == str.charAt(right)) {
				++left; --right;
			} else {
				return false;
			}
		}
		paSet.add(str);
		return true;
	}
}
