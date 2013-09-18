package coursera.algoritms.part1.assigments1;
import WeightedQuickUnionUF;

public class Percolation {
	WeightedQuickUnionUF quickUnion;
	private int gridSize;
	private int[][] grid;
	private int topVirtualSite;
	private int bottomVirtualSite;
	public Percolation(int n) {
	   // create N-by-N grid, with all sites blocked
	   quickUnion = new WeightedQuickUnionUF(n * n + 2);
	   gridSize = n;
	   grid = new int[n + 1][n + 1];
	   for (int i = 1; i <= n; ++i) {
		   for (int j = 1; j <= n; ++j) {
			   grid[i][j] = 0;
		   }
	   }
	   topVirtualSite = n * n;
	   bottomVirtualSite = n * n + 1;
	   for (int i = 0; i < n; ++i) {
		   quickUnion.union(i, topVirtualSite);
	   }
	   int gridCount = n * n - 1;
	   for (int j = gridCount; j > gridCount - gridSize; --j) {
		   quickUnion.union(bottomVirtualSite, j);
	   }
	}
	
	public void open(int i, int j) {
		// open site (row i, column j) if it is not already
		checkIndex(i, j);
		grid[i][j] = 1;
		int left = j - 1;
		int top = i - 1;
		int right = j + 1;
		int bottom = i + 1;
		connect(i, j, i, left);
		connect(i, j, i, right);
		connect(i, j, top, j);
		connect(i, j, bottom, j);
	}
	
	//connect an open site to another open site
	private void connect(int i, int j, int newi, int newj) {
		if (isValidIndex(newi, newj) && isOpen(newi, newj)) {
			quickUnion.union(getIndexInArray(i, j), getIndexInArray(newi, newj));
		}
	}
	
	public boolean isOpen(int i, int j) {
		// is site (row i, column j) open?
		checkIndex(i, j);
		return grid[i][j] == 1;
	}
	public boolean isFull(int i, int j) {
		// is site (row i, column j) full?
		checkIndex(i, j);
		return isOpen(i, j) && quickUnion.connected(getIndexInArray(i, j), topVirtualSite);
	}

	private int getIndexInArray(int i, int j) {
		return (i - 1) * gridSize + j - 1;
	}
	public boolean percolates() {
		return quickUnion.connected(bottomVirtualSite, topVirtualSite);
	}
	
	private void checkIndex(int i, int j) {
		if (!isValidIndex(i, j)) {
			throw new IndexOutOfBoundsException();
		}
	}

	private boolean isValidIndex(int i, int j) {
		return 1 <= i && i <= gridSize && 1 <= j && j <= gridSize;
	}
}
