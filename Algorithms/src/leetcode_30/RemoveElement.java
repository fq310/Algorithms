package leetcode_30;

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
    	if (A.length == 0) return 0;
    	int endIndex = A.length - 1;
    	int i = 0;
    	while (i < endIndex) {
    		if (A[i] == elem) {
    			A[i] = A[endIndex];
    			--endIndex;
    		} else {
    			++i;
    		}
    	}
    	if (A[endIndex] == elem)
    		--endIndex;
        return endIndex + 1;
    }
}
