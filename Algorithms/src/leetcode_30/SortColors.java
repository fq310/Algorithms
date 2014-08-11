package leetcode_30;

public class SortColors {
    public void sortColors(int[] A) {
        int[] count = new int[3];
        for (int i : A) {
        	if (i == 0)
        		++count[0];
        	if (i == 1)
        		++count[1];
        	if (i == 2)
        		++count[2];
        }
        int i = 0;
        for (; i < count[0]; ++i) {
        	A[i] = 0;
        }
        for (; i < count[0] + count[1]; ++i) {
        	A[i] = 1;
        }
        for (; i < A.length; ++i) {
        	A[i] = 2;
        }
    }
}
