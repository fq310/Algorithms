package leetcode_30;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumberII {
    public int singleNumber(int[] A) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i : A) {
    		Integer value = map.get(i);
    		if (value == null) {
    			map.put(i, 1);
    		} else {
    			map.put(i, 1 + value);
    		}
    	}
    	for (Entry<Integer, Integer> entry : map.entrySet()) {
    		Integer times = entry.getValue();
    		Integer number = entry.getKey();
    		if (times == 1) return number;
    	}
        return -1;
    }
}
