package leetcode_20;

public class Sqrt {
    public int sqrt(int x) {
    	if (x == 0) return 0;
    	double current = 1.0, last = 0.0;
    	while (current != last) {
    		last = current;
    		current = (current + x / current) / 2;
    	}
    	return (int)current;
    }
}
