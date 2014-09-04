package leetcode_20;


public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
    	if (s3.length() != (s1.length() + s2.length())) return false;
    	if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) return true;
    	boolean[][] result = new boolean[s1.length() + 1][s2.length() + 1];
    	for (int i = 1; i <= s1.length(); ++i) {
    		if (s1.charAt(i - 1) == s3.charAt(i - 1))
    			result[i][0] = true;
    		else
    			break;
    	}
    	for (int i = 1; i <= s2.length(); ++i) {
    		if (s2.charAt(i - 1) == s3.charAt(i - 1))
    			result[0][i] = true;
    		else
    			break;
    	}
    	
    	for (int i = 1; i < result.length; ++i) {
    		for (int j = 1; j < result[i].length; ++j) {
    			result[i][j] = (result[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
    					(result[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
    		}
    	}
        return result[s1.length()][s2.length()];
    }
    
}
