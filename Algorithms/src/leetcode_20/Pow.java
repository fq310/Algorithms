package leetcode_20;

public class Pow {
    public double pow(double x, int n) {
    	if (n < 0) return 1.0 / pow2(x, -n);
        return pow2(x, n);
    }
    
    private double pow2(double x, int n) {
    	if (n == 0) return 1;
    	double halfValue = pow2(x, n/2);
    	if (n % 2 == 0) {
    		return halfValue * halfValue;
    	} else {
    		return halfValue * halfValue * x;
    	}
    }
}
