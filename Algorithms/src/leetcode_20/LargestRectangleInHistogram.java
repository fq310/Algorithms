package leetcode_20;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
    	int maxArea = 0;
    	reverseIfNecessary(height);
    	for (int i = 0; i < height.length; ++i) {
    		if (i + 1 < height.length && height[i + 1] >= height[i]) 
    			continue;
    		int minHeight = height[i];
    		for (int j = i; j >=0; --j) {
    			minHeight = Math.min(minHeight, height[j]);
    			maxArea = Math.max(maxArea, (i - j + 1) * minHeight);
    		}
    	}
    	return maxArea;
    }
    
    private void reverseIfNecessary(int[] data) {
    	int upSum = 0, downSum = 0;
		for (int i = 0; i < data.length - 1; ++i) {
			if (data[i] <= data[i + 1])
				++upSum;
			else
				downSum++;
		}
		if (upSum >= downSum) return;
		int i = 0, j = data.length - 1;
		while (i < j) {
			int temp = data[i];
			data[i] = data[j];
			data[j] = temp;
			++i;
			--j;
		}
	}
    public int largestRectangleArea3(int[] height) {
    	Stack<Integer> stack = new Stack<>();
    	int index = 0;
    	int maxArea = 0;
    	while (index < height.length) {
    		if (stack.isEmpty() || height[stack.peek()] <= height[index]) {
    			stack.push(index++);
    		} else {
    			int topIndex = stack.pop();
    			int areaTopIndex = height[topIndex] * (stack.isEmpty() ? index : index - stack.peek() - 1);
    			if (maxArea < areaTopIndex) {
    				maxArea = areaTopIndex;
    			}
    		}
    	}
    	while (stack.size() > 0) {
    		int topIndex = stack.pop();
			int areaTopIndex = height[topIndex] * (stack.isEmpty() ? index : index - stack.peek() - 1);
			if (maxArea < areaTopIndex) {
				maxArea = areaTopIndex;
			}
    	}
         return maxArea;
    }
}
