package leetcode_20;

public class AddBinary {
    public String addBinary(String a, String b) {
    	String shortOne = "";
    	String longerOne = "";
    	if (a.length() > b.length()) {
    		longerOne = a;
    		shortOne = b;
    	} else {
    		longerOne = b;
    		shortOne = a;
    	}
    	int i = shortOne.length() - 1, j = longerOne.length() - 1;
    	StringBuilder result = new StringBuilder();
    	int carry = 0;
    	while (j >= 0) {
    		int sum = 0;
    		if (i >= 0) {
    			sum = Integer.parseInt(longerOne.substring(j, j + 1)) + Integer.parseInt(shortOne.substring(i, i + 1)) + carry;
    		} else { 
    			sum = Integer.parseInt(longerOne.substring(j, j + 1)) + carry;
    		}
    		if (sum <= 1) {
    			carry = 0;
    		} else {
    			carry = 1;
    			sum = sum - 2;
    		}
    		result.insert(0, sum);
    		--j;
    		--i;
    	}
    	if (carry != 0) {
    		result.insert(0, carry);
    	}
        return result.toString();
    }
}
