package leetcode_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
    	if ( T.length() > S.length()) return "";
    	Map<Character, Integer> map = new HashMap<>();
    	for (char c : T.toCharArray()) {
    		Integer count = map.get(c);
    		if (count == null) {
    			count = 0;
    		}
    		map.put(c, ++count);
    	}
    	Map<Character, Integer> buffer = new HashMap<>();
    	List<String> resultList = new ArrayList<>();
    	List<Integer> insertIndex = new ArrayList<>();
    	for (int i = 0; i < S.length();) {
    		char c = S.charAt(i);
    		if (map.containsKey(c)) {
    			Integer count = buffer.get(c);
    			if (count == null) count = 0;
    			++count;
    			buffer.put(c, count);
    			if (count > map.get(c)) {
    				buffer.clear();
    				if (insertIndex.size() > 1)
    					i = insertIndex.get(1);
					insertIndex.clear();
    				continue;
    			} else {
    				insertIndex.add(i);
    			}
    		}
    		if (insertIndex.size() == T.length()) {
    			resultList.add(S.substring(insertIndex.get(0), insertIndex.get(insertIndex.size() - 1) + 1));
    			buffer.clear();
    			if (insertIndex.size() > 1)
    				i = insertIndex.get(1);
    			else ++i;
    			insertIndex.clear();
    		} else {
    			++i;
    		}
    	}
    	Collections.sort(resultList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) return -1;
				if (o1.length() > o2.length()) return 1;
				return 0;
			}
    	});
        return resultList.size() > 0 ? resultList.get(0) : "";
    }
  
}
