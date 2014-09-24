package leetcode_20;

public class StringToInteger {
    public int atoi(String str) {
    	str = str.trim();
    	boolean isMinus = false;
    	StringBuilder buffer = new StringBuilder();
    	if (str.startsWith("-")) {
    		isMinus = true;
    		str = str.substring(1);
    	} else if (str.startsWith("+")) {
    		str = str.substring(1);
    	}
    	for (int i = 0; i < str.length(); ++i) {
    		char c = str.charAt(i);
    		if (Character.isDigit(c)) {
    			buffer.append(c);
    		} else {
    			break;
    		}
    	}
    	int sum = 0;
    	if (buffer.length() > 10) {
    		return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    	}
    	for (int i = 0; i < buffer.length(); ++i) {
    		if (isMinus == false && sum >= Integer.MAX_VALUE / 10 && buffer.charAt(i) - '0' > 7) return Integer.MAX_VALUE;
    		if (isMinus && (sum * -1) <= Integer.MIN_VALUE / 10 && buffer.charAt(i) - '0' > 7) return Integer.MIN_VALUE;
    		char c = buffer.charAt(i);
    		sum = sum * 10 + (c - '0');
    	}
        return isMinus ? sum * -1 : sum;
    }
}
