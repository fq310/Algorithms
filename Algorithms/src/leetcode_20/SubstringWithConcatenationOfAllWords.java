package leetcode_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
    	List<Integer> result = new ArrayList<>();
    	Map<String, Integer> map = new HashMap<>();
    	for (String word : L) {
    		Integer count = map.get(word);
    		if (count == null) {
    			map.put(word, 1);
    		} else {
    			map.put(word, ++count);
    		}
    	}
    	
    	for (int i = 0; i <= S.length() - (L.length * L[0].length()); ++i) {
    		HashMap<String, Integer> currentMap = new HashMap<>();
    		int j = 0, len = L[0].length();
    		for (; j < L.length; ++j) {
    			String str = S.substring(i + j * len, i + j * len + len);
    			Integer count = currentMap.get(str);
    			if (count == null) count = 1;
    			else ++count;
    			if (map.get(str) == null || count > map.get(str)) break;
    			currentMap.put(str, count);
    		}
    		if (j == L.length) result.add(i);
    	}
        return result;
    }

}
