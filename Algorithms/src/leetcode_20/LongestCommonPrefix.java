package leetcode_20;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) return "";
    	if (strs.length == 1) return strs[0];
    	StringBuilder result = new StringBuilder();
    	int i = 0;
    	while (true) {
    		boolean equal = true;
    		for (int j = 0; j < strs.length - 1; ++j) {
    			if (i < strs[j].length() && 
    					i < strs[j + 1].length() &&
    					strs[j].charAt(i) == strs[j + 1].charAt(i)) {
    				continue;
    			} else {
    				equal = false;
    			}
    		}
    		if (equal == false) {
    			break;
    		} else {
    			result.append(strs[0].charAt(i));
    			++i;
    		}
    	}
        return result.toString();
    }
}
