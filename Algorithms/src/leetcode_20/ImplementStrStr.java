package leetcode_20;

public class ImplementStrStr {
    public String strStr(String haystack, String needle) {
    	if (needle.length() == 0) return haystack;
    	if (haystack.length() < needle.length()) return null;
    	if (haystack.length() == needle.length()) return haystack.equals(needle) ? haystack : null;
    	
    	for (int i = 0; i < haystack.length() - needle.length() + 1; ++i) {
    		int k = i, j = 0;
    		boolean equal = true;
    		while (j < needle.length()) {
    			if (haystack.charAt(k) != needle.charAt(j)) {
    				equal = false;
    				break;
    			}
    			++k; ++j;
    		}
    		if (equal) {
    			return haystack.substring(i);
    		}
    	}
        return null;
    }
}
