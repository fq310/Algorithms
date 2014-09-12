package leetcode_20;

public class Candy {
    public int candy(int[] ratings) {
    	if (ratings == null || ratings.length == 0) return 0;
    	if (ratings.length == 1) return 1;
    	int[] leftCandy = new int[ratings.length];
    	int[] rightCandy = new int[ratings.length];
    	
    	int currentCandy = 1;
    	leftCandy[0] = 1;
    	for (int i = 1; i < ratings.length; ++i) {
    		if (ratings[i] > ratings[i - 1]) {
    			leftCandy[i] = ++currentCandy;
    		} else {
    			currentCandy = 1;
    			leftCandy[i] = 1;
    		}
    	}
    	currentCandy = 1;
    	rightCandy[rightCandy.length - 1] = 1;
    	for (int i = ratings.length - 1; i > 0; --i) {
    		if (ratings[i - 1] > ratings[i]) {
    			rightCandy[i - 1] = ++currentCandy;
    		} else {
    			currentCandy = 1;
    			rightCandy[i - 1] = 1;
    		}
    	}
    	
    	for (int i = 0; i < leftCandy.length; ++i) {
    		leftCandy[i] = Math.max(leftCandy[i], rightCandy[i]);
    	}
    	
    	int sum = 0;
    	for (int i : leftCandy) sum += i;
        return sum;
    }

}
