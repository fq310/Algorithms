package leetcode_20;

public class CountAndSay {
    public String countAndSay(int n) {
    	StringBuilder result = new StringBuilder();
    	String str = "1";
    	result.append(str);
    	for (int i = 1; i < n; ++i) {
    		int start = 0, end = 0;
    		result.setLength(0);
    		while (start < str.length() && end < str.length()) {
    			if (str.charAt(start) == str.charAt(end)) {
    				++end;
    			} else {
    				int count = end - start;
    				result.append(String.valueOf(count) + String.valueOf(str.charAt(start)));
    				start = end;
    			}
    		}
    		if (end - start > 0) {
    			int count = end - start;
				result.append(String.valueOf(count) + String.valueOf(str.charAt(start)));
				start = end;
    		}
    		str = result.toString();
    	}
        return result.toString();
    }
}
