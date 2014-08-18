package leetcode_30;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
    	int i = 0;
    	while (i < A.length && target > A[i]) {
    		++i;
    	}
        return i;
    }
}
