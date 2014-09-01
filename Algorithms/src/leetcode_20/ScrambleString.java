package leetcode_20;

import java.util.Arrays;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
    	if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
    	if (s1.equals(s2)) return true;
    	char[] s1Array = s1.toCharArray();
    	char[] s2Array = s2.toCharArray();
    	Arrays.sort(s1Array);
    	Arrays.sort(s2Array);
    	if (!Arrays.equals(s1Array, s2Array)) return false;
    	for (int i = 1; i < s1.length(); ++i) {
    		if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
    				(isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))) {
    			return true;
    		}
    	}
        return false;    
    }
}
