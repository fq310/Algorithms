package leetcode_20;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
    	int maxLength = 0;
    	Set<Integer> set = new HashSet<>();
    	for (int i : num) {
    		set.add(i);
    	}
    	for (int i : set) {
    		if (set.contains(i - 1)) continue;
    		int length = 1;
    		while (i < Integer.MAX_VALUE && set.contains(++i)) {
    			++length;
    		}
    		maxLength = Math.max(length, maxLength);
    	}
        return maxLength;
    }
}
