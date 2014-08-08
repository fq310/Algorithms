package leetcode_30;

public class RemoveDuplicatesFromSortedArrayII {
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
    			if (end >= start + 3) {
	    			removeValue(start + 2, end, A);
	    			length = length - currentDuplicateLength + 1;
	    			currentDuplicateLength = 0;
	    			start = start + 2;
	    			end = start + 1;
    			} else if (end <= start + 1){
    				++start;
    				++end;
    			} else {
    				start = end;
    				end++;
    				currentDuplicateLength = 0;
    			}
    		}
    	}
    	if (currentDuplicateLength > 1)
    		length = length - currentDuplicateLength + 1;
    		
        return length;
    }

	private void removeValue(int start, int end, int[] a) {
		for (int i = end; i < a.length; ++i) {
			a[start++] = a[end++];
		}
	}
}
