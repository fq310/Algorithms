package leetcode_30;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix.length == 0) return false;
    	return searchRow(matrix, 0, matrix.length * matrix[matrix.length - 1].length - 1, target);
    }

	private boolean searchRow(int[][] matrix, int low, int high, int target) {
		if (low > high) return false;
		int mid = (low + high) / 2;
		int cloumn = mid % matrix[0].length;
		int row = mid / matrix[0].length;
		if (matrix[row][cloumn] == target) return true;
		if (matrix[row][cloumn] > target) return searchRow(matrix, low, mid - 1, target);
		else return searchRow(matrix, mid + 1, high, target);
	}

}
