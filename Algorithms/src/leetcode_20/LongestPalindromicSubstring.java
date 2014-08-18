package leetcode_20;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	if (s.length() == 1) return s;
    	String maxStr = "";
    	for (int i = 0; i < s.length(); ++i) {
    		int j = i + 1;
    		if (j < s.length() && s.charAt(i) == s.charAt(j)) {
				String palindrome = getPalindrome(s, i, j);
				if (palindrome.length() > maxStr.length())
					maxStr = palindrome;
    		}
    		
    		int k = i + 2;
    		if (k < s.length() && s.charAt(i) == s.charAt(k)) {
    			String palindrome = getPalindrome(s, i, k);
				if (palindrome.length() > maxStr.length())
					maxStr = palindrome;
    		}
    	}
        return maxStr;
    }

	private String getPalindrome(String str, int start, int end) {
		while (start >= 0 && end < str.length()) {
			if (str.charAt(start) == str.charAt(end)) {
				--start;
				++end;
			} else {
				break;
			}
		}
		return str.substring(start + 1, end);
	}
}
