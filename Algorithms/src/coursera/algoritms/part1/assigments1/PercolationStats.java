public class PercolationStats {
	private Percolation percolation;
	private double mean;
	private double stddev;
	private int experimentTimes;
	private double[] means;
	 // perform T independent computational experiments on an N-by-N grid
	   public PercolationStats(int N, int T) {
		   experimentTimes = T;
		   means = new double[T];
		   int siteNumber = N*N;
		   for (int i = 0; i < T; ++i) {
			   percolation = new Percolation(N);
			   while (percolation.percolates() == false) {
				   int randomSite = StdRandom.uniform(0, siteNumber);
				   int xIndexOfArray = randomSite / N + 1;
				   int yIndexOfArray = randomSite % N + 1;
				   if (percolation.isOpen(xIndexOfArray, yIndexOfArray))
					   continue;
				   percolation.open(xIndexOfArray, yIndexOfArray);
			   }
			   
			   int[] openSiteCount = new int[siteNumber];
			   for (int j = 0; j < siteNumber; ++j) {
				   int xIndexOfArray = j / N + 1;
				   int yIndexOfArray = j % N + 1;
				   boolean isOpen = percolation.isOpen(xIndexOfArray, yIndexOfArray);
				   if (isOpen) {
					   openSiteCount[j] = 1;
				   }
			   }
			   means[i] = StdStats.mean(openSiteCount);
		   }
		   
		   mean = StdStats.mean(means);
		   stddev = StdStats.stddev(means);
	   }
	   public double mean() {
		   // sample mean of percolation threshold
		   return mean;
	   }
	   public double stddev() {
		   // sample standard deviation of percolation threshold
		   return stddev;
	   }
	   public double confidenceLo() {
		   // returns lower bound of the 95% confidence interval
		   return mean - 1.96 * stddev / Math.sqrt(experimentTimes);
	   }
	   public double confidenceHi() {
		   // returns upper bound of the 95% confidence interval
		   return mean + 1.96 * stddev / Math.sqrt(experimentTimes);
	   }
	   public static void main(String[] args) {
		   // test client, described below
		  if(StdIn.isEmpty()) return;
		  int N = StdIn.readInt();
		  if(StdIn.isEmpty()) return;
		  int T = StdIn.readInt();
		  PercolationStats ps = new PercolationStats(N, T);
		  StdOut.println("mean = " + ps.mean());
		  StdOut.println("stddev = " + ps.stddev());
		  StdOut.println("95% confidence interval = " + ps.confidenceLo() + ", " + ps.confidenceHi());
		  
	   }
	}
