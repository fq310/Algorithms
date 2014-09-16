package leetcode_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
	private int capacity;
	private int currentSize = 0;
	private Map<Integer, Integer> keyValueMap = new HashMap<>();
	private List<Integer> recentList = new ArrayList<>();
	class Data {
		int key;
		int value;
	}
    public LRUCache(int capacity) {
		this.capacity = capacity;
    }
    
    public int get(int key) {
    	Integer value = keyValueMap.get(key);
    	if (value == null) return -1;
        return value;
    }
    
    public void set(int key, int value) {
    	if (currentSize < capacity) {
    		if (keyValueMap.containsKey(key)) {
    			refreshKey(key);
    		} else {
    			++currentSize;
    			recentList.add(key);
    		}
    	} else {
    		if (keyValueMap.containsKey(key)) {
    			refreshKey(key);
    		} else {
    			Integer oldKey = recentList.remove(0);
    			keyValueMap.remove(oldKey);
    			recentList.add(key);
    		}
    	}
    	keyValueMap.put(key, value);
    }

	private void refreshKey(int key) {
		int i = 0;
		for (; i < recentList.size(); ++i) {
			if (recentList.get(i) == key) {
				break;
			}
		}
		recentList.remove(i);
		recentList.add(key);
	}
}
