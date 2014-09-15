package leetcode_20;

import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
    	boolean[] isBreakable = new boolean[s.length() + 1];
    	isBreakable[0] = true;
    	for (int i = 1; i <= s.length(); ++i) {
    		for (int j = 0; j < i; ++j) {
    			if (isBreakable[j] && dict.contains(s.substring(j, i))) {
    				isBreakable[i] = true;
    				break;
    			}
    		}
    	}
        return isBreakable[s.length()];
    }	
}
