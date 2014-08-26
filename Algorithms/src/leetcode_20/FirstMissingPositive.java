package leetcode_20;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
    	for (int i = 0; i < A.length; ++i) {
    		if (A[i] - 1 == i) continue;
    		if (A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1]) continue;
    		swap(A, i, A[i] - 1);
    		--i;
    	}
    	for (int i = 0; i < A.length; ++i) {
    		if (A[i] - 1 != i) return i + 1;
    	}
        return A.length + 1;
    }

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
