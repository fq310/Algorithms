package leetcode_20;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		boolean[] output = new boolean[n];
		StringBuilder buf = new StringBuilder("");
		int factorial = 1;
		for (int i = 1; i <= n; ++i) {
			factorial *= i;
		}
		for (int i = n; i > 0; --i) {
			factorial = factorial / i;
			int valueI = k / factorial;
			buf.append(valueI);
			k = k % factorial;
		}
		return buf.toString();
	}
}
