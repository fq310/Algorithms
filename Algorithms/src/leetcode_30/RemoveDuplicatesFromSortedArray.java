package leetcode_30;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
    	int start = 0;
    	int end = 1;
    	int length = A.length;
    	int currentDuplicateLength = 0;
    	while (end < length && start < length) {
    		if (A[start] == A[end]) {
    			++end;
    			++currentDuplicateLength;
    		} else {
    			if (start + 1 != end) {
	    			removeValue(start + 1, end, A);
	    			length = length - currentDuplicateLength;
	    			currentDuplicateLength = 0;
	    			++start;
	    			end = start + 1;
    			} else {
    				++start;
    				++end;
    			}
    		}
    	}
    	if (currentDuplicateLength != 0)
    		length = length - currentDuplicateLength;
    		
        return length;
    }

	private void removeValue(int start, int end, int[] a) {
		for (int i = end; i < a.length; ++i) {
			a[start++] = a[end++];
		}
	}
}
