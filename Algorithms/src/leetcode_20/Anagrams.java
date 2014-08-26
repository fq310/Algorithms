package leetcode_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
    	Map<String, List<String>> map = new HashMap<>();
    	for (String str : strs) {
    		int[] charArray = new int[128];
    		for (int i = 0; i < str.length(); ++i) {
    			++charArray[str.charAt(i)];
    		}
    		StringBuilder code = new StringBuilder();
    		for (int i = 0; i < charArray.length; ++i) {
    			if (charArray[i] > 0) {
    				code.append(charArray[i]).append(i);
    			}
    		}
    		List<String> words = map.get(code.toString());
    		if (words == null) {
    			words = new ArrayList<String>();
    			map.put(code.toString(), words);
    		}
    		words.add(str);
    	}
    	List<String> result = new ArrayList<>();
    	for (List<String> value : map.values()) {
    		if (value.size() > 1)
    			result.addAll(value);
    	}
        return result;
    }
}
