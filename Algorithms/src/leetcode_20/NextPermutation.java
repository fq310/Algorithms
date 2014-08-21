package leetcode_20;

public class NextPermutation {
    public void nextPermutation(int[] num) {
    	if (num == null || num.length < 2) return;
    	
        int breakIndex = num.length - 2;
        while (breakIndex >= 0 && num[breakIndex] >= num[breakIndex + 1]) {
        	--breakIndex;
        }
        if (breakIndex < 0) {
        	reverse(num, 0, num.length - 1);
        	return;
        }
        
        int swapIndex = num.length - 1;
        while (swapIndex > breakIndex && num[swapIndex] <= num[breakIndex]) {
        	--swapIndex;
        }
        swap(num, breakIndex, swapIndex);
        
        reverse(num, breakIndex + 1, num.length - 1);
    }

	private void reverse(int[] num, int i, int j) {
		while (i < j) {
			swap(num, i, j);
			++i; --j;
		}
	}
	
	private void swap(int[] num, int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
}


