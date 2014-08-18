package leetcode_20;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	int maxLength = 0, length = 0;
    	for (int i = 0; i < s.length(); ++i) {
    		++length;
    		Character character = Character.valueOf(s.charAt(i));
			if (map.get(character) != null) {
    			length = Math.min(i - map.get(character), length);
    		}
			maxLength = Math.max(maxLength, length);
			map.put(character, i);
    	}
        return maxLength;
    }
}
