package leetcode_20;

public class StringToInteger {
    public int atoi(String str) {
    	str = str.trim();
    	StringBuilder buffer = new StringBuilder();
    	if (str.startsWith("-")) {
    		buffer.append("-");
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
    	
    	int result = 0;
    	try {
    		result = Integer.parseInt(buffer.toString());
    	} catch (NumberFormatException e) {
    	}
        return result;
    }
}
