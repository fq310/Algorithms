package leetcode_20;

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
    	int index = search(target, A, 0, A.length - 1);
    	if (index == -1) return new int[]{-1, -1};
    	int left = index, right = index;
    	while (left >= 0 && A[left] == target) {
    		--left;
    	}
    	while (right < A.length && A[right] == target) {
    		++right;
    	}
        return new int[]{++left, --right};
    }
    
    private int search(int target, int[] data, int low, int high) {
    	if (low > high) return -1;
    	int mid = (low + high) / 2;
    	if (target == data[mid]) return mid;
    	if (target < data[mid]) return search(target, data, low, mid - 1);
    	else return search(target, data, mid + 1, high);
    }
}
