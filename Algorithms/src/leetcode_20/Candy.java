package leetcode_20;

import java.util.ArrayList;
import java.util.List;

public class Candy {
    public int candy(int[] ratings) {
    	if (ratings == null || ratings.length == 0) return 0;
    	if (ratings.length == 1) return 1;
    	List<Integer> valleys = new ArrayList<>();
    	if (ratings[0] < ratings[1]) valleys.add(0);
    	if (ratings[ratings.length - 1] < ratings[ratings.length - 2]) valleys.add(ratings.length - 1);
    	for (int i = 1; i < ratings.length - 1; ++i) {
    		if (ratings[i - 1] >= ratings[i] && ratings[i] <= ratings[i + 1]) {
    			valleys.add(i);
    		}
    	}
    	if (valleys.isEmpty()) return ratings.length;
    	int[] candy = new int[ratings.length];
    	for (Integer valley : valleys) {
    		candy[valley] = 1;
    		int left = valley - 1;
    		int currentCandy = 1;
    		for (; left >= 0 && ratings[left] >= ratings[left + 1]; --left) {
    			int leftCandy = 1;
    			if (ratings[left] == ratings[left + 1]) leftCandy = 1;
    			else {
    				++currentCandy;
    				leftCandy = currentCandy;
    			}
    			if (candy[left] > 0) {
    				candy[left] = Math.max(candy[left], leftCandy);
    			} else {
    				candy[left] = leftCandy;
    			}
    		}
    		
    		int right = valley + 1;
    		currentCandy = 1;
    		for (; right < ratings.length && ratings[right] >= ratings[right - 1]; ++right) {
    			int rightCandy = 1;
    			if (ratings[right] == ratings[right - 1]) rightCandy = 1;
    			else {
    				++currentCandy;
    				rightCandy = currentCandy;
    			}
    			if (candy[right] > 0) {
    				candy[right] = Math.max(candy[right], right);
    			} else {
    				candy[right] = rightCandy;
    			}
    		}
    	}
    	int sum = 0;
    	for (int c : candy) {
    		sum += c;
    	}
        return sum;
    }
}
