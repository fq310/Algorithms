package leetcode_20;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
    	if (s == null || s.length()== 0) return true;
    	StringBuilder reversedStr = new StringBuilder();
    	for (int i = s.length()- 1; i >= 0; --i) {
    		char c = s.charAt(i);
    		if (isAlphaNumeric(c)) {
    			if (Character.isUpperCase(c))
    				c = Character.toLowerCase(c);
    			reversedStr.append(c);
    		}
    	}
    	StringBuilder str = new StringBuilder();
    	for (int i = 0; i < s.length(); ++i) {
    		char c = s.charAt(i);
    		if (isAlphaNumeric(c)) {
    			if (Character.isUpperCase(c))
    				c = Character.toLowerCase(c);
    			str.append(c);
    		}
    	}
    	return str.toString().equals(reversedStr.toString());
    }

	private boolean isAlphaNumeric(char c) {
		return Character.isAlphabetic(c) || 
				Character.isDigit(c);
	}
}
