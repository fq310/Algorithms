package leetcode_20;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	String str = String.valueOf(x);
    	StringBuilder reversedStr = new StringBuilder();
    	for (int i = str.length() - 1; i >= 0; --i) {
    		reversedStr.append(str.charAt(i));
    	}
        return reversedStr.toString().equals(str);
    }
}
