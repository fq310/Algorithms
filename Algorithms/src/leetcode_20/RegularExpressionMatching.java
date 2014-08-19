package leetcode_20;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	int i = 0, j = 0;
    	while (i < s.length() && j < p.length()) {
    		if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
    			j = j + 2;
    			if (j > p.length() - 1) break;
    		}
    		if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
    			++j; ++i;
    		} else {
    			int k = i;
    			while (k < s.length() && s.charAt(k) != p.charAt(j)) {
    				++k;
    			}
    			if (k == s.length()) {
    				return false;
    			} else {
    				i = k;
    				++j; ++i;
    			}
    		}
    	}
        return true;
    }
}
