package leetcode;

public class ReverseInteger {
    public int reverse(int x) {
    	int minus = 1;
    	if (x < 0){
    		minus = -1;
    		x = x * -1;
    	}
    	String str = String.valueOf(x);
    	StringBuilder result = new StringBuilder();
    	for (int i = str.length() - 1; i >= 0; --i) {
    		result.append(str.charAt(i));
    	}
        return Integer.valueOf(result.toString()) * minus;
    }
}
