package leetcode_30;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
    	List<Integer> result = new ArrayList<>();
    	for (int i : digits) {
    		result.add(i);
    	}
    	int carry = 1;
    	for (int i = result.size() - 1; i >= 0; --i) {
    		int value = result.get(i);
    		value = value + carry;
    		if (value > 9) {
    			result.set(i, value % 10);
    			carry = 1;
    		} else {
    			result.set(i, value);
    			carry = 0;
    		}
    	}
    	if (carry == 1) {
    		result.add(0, 1);
    	}
    	int[] resultArray = new int[result.size()];
    	for (int i = 0; i < resultArray.length; ++i) {
    		resultArray[i] = result.get(i);
    	}
        return resultArray;
    }
}
