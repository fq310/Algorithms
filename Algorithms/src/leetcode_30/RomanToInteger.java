package leetcode_30;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int[] values = new int[s.length()];
        for (int i =0; i < s.length(); ++i) {
        	values[i] = map.get(String.valueOf(s.charAt(i)));
        }
        int result = 0;
        for (int i = 0; i < values.length; ++i) {
        	if (i < values.length - 1 && values[i] < values[i + 1]) {
        		result += (values[i + 1] - values[i]);
        		++i;
        	} else {
        		result += values[i];
        	}
        }
        return result;
    }
}
