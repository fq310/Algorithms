package programmingpearls1.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Anagram {
	public List<List<String>> findAnagram(List<String> words) {
		List<List<String>> result = new LinkedList<>();
		Map<String, List<String>> wordMap = new HashMap<>();
		for (String word : words) {
			String mark = sort(word);
			List<String> wordList = wordMap.get(mark);
			if (wordList == null) {
				wordList = new ArrayList<String>();
				wordList.add(word);
				wordMap.put(mark, wordList);
			} else {
				wordList.add(word);
			}
		}
		for (Entry<String,List<String>> s : wordMap.entrySet()) {
			List<String> wordList = s.getValue();
			if (wordList.size() > 1) {
				result.add(wordList);
			}
		}
		return result;
	}

	private String sort(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}

class AnagramNode {
	
}
