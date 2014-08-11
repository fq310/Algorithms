package leetcode_30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
    	Queue<List<Integer>> queue = new LinkedList<>();
    	for (int i = 1; i <= n; ++i) {
    		List<Integer> listForOneElement = new LinkedList<>();
    		listForOneElement.add(i);
    		queue.add(listForOneElement);
    	}
    	List<List<Integer>> result = new ArrayList<>();
    	while (queue.size() > 0) {
    		List<Integer> list = queue.poll();
    		if (list.size() == k) {
    			result.add(list);
    		} else {
    			for (int i = list.get(list.size() - 1) + 1; i <= n; ++i) {
    				List<Integer> nextList = new LinkedList<>();
    				nextList.addAll(list);
    				nextList.add(i);
    				queue.add(nextList);
    			}
    		}
    	}
        return result;
    }
}




