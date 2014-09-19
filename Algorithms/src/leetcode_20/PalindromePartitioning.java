package leetcode_20;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
    	List<List<String>> result = new ArrayList<>();
    	search(s, new ArrayList<String>(), result);
        return result;
    }

	private void search(String s, List<String> partitions, List<List<String>> result) {
		if (s.length() == 0) {
			result.add(partitions);
			return;
		}
		for (int i = 0; i < s.length(); ++i) {
			String str = s.substring(0, i + 1);
			if (isPalindom(str)) {
				List<String> newPartitions = new ArrayList<>();
				newPartitions.addAll(partitions);
				newPartitions.add(str);
				search(s.substring(i + 1), newPartitions, result);
			}
		}
	}

	private boolean isPalindom(String str) {
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) == str.charAt(right)) {
				++left; --right;
			} else {
				return false;
			}
		}
		return true;
	}
}
