package leetcode_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
    	Map<Character, List<String>> map = getDictMap(dict);
    	List<String> result = new ArrayList<>();
    	if (isBreakable(s, dict) == false) return result;
    	search(s, "", result, map, dict);
        return result;
    }

	private boolean isBreakable(String s, Set<String> dict) {
		boolean[] isBreakable = new boolean[s.length() + 1];
    	isBreakable[0] = true;
    	for (int i = 1; i <= s.length(); ++i) {
    		for (int j = 0; j < i; ++j) {
    			if (isBreakable[j] && dict.contains(s.substring(j, i))) {
    				isBreakable[i] = true;
    				break;
    			}
    		}
    	}
		return isBreakable[s.length()];
	}

	private Map<Character, List<String>> getDictMap(Set<String> dict) {
		Map<Character, List<String>> map = new HashMap<>();
    	for (String str : dict) {
    		List<String> start = map.get(str.charAt(0));
    		if (start == null) {
    			start = new ArrayList<>();
    			map.put(str.charAt(0), start);
    		}
    		start.add(str);
    	}
		return map;
	}

	private void search(String s, String foundStrings,
			List<String> result, Map<Character, List<String>> map, Set<String> dict) {
		if (s.length() == 0) {
			result.add(foundStrings.trim());
			return;
		}
		List<String> words = map.get(s.charAt(0));
		if (words == null || words.size() == 0) return;
		for (String word : words) {
			if (s.startsWith(word) && word.length() <= s.length())
				search(s.substring(word.length()), foundStrings + " " + word, result, map, dict);
		}
	}
}
