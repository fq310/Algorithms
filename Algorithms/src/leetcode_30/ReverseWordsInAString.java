package leetcode_30;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
    	StringBuilder result = new StringBuilder();
    	List<String> list = new ArrayList<>();
    	for (int i = 0; i < s.length(); ++i) {
    		char c = s.charAt(i);
    		if (c == ' ') continue;
    		int start = i;
    		int end = i;
    		while (end < s.length() && s.charAt(end) != ' ') {
    			++end;
    		}
    		list.add(s.substring(start, end));
    		i = end;
    	}
    	for (int i = list.size() - 1; i >=0 ; --i) {
    		result.append(list.get(i));
    		if (i != 0) {
    			result.append(" ");
    		}
    	}
        return result.toString();
    }
}

