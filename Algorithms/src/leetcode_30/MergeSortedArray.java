package leetcode_30;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
        	if (A[i] < B[j]) {
        		temp[k++] = A[i++];
        	} else {
        		temp[k++] = B[j++];
        	}
        }
        while (i < m) {
        	temp[k++] = A[i++];
        }
        while (j < n) {
        	temp[k++] = B[j++];
        }
        k = 0;
        while (k < m + n) {
        	A[k] = temp[k];
        	++k;
        }
    }
}
