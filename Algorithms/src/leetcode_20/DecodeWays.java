package leetcode_20;

public class DecodeWays {
    public int numDecodings(String s) {
    	if (s == null || s.length() == 0) return 0;
    	if (s.length() == 1) {
    		if (s.charAt(0) == '0') return 0;
    		else return 1;
    	}
    	int[] result = new int[s.length() + 1];
    	result[0] = 1;
    	if (s.charAt(0) != '0') result[1] = 1;
    	for (int i = 2; i <= s.length(); ++i) {
    		int one = s.charAt(i - 2) - '0';
    		int two = s.charAt(i - 1) - '0';
    		int sum = one * 10 + two;
    		if (sum >= 10 && sum <= 26) result[i] += result[i - 2];
    		if (two != 0) result[i] += result[i - 1];
    	}
        return result[s.length()];
    }
	
    public int numDecodings2(String s) {
    	int[] sum = new int[1];
    	decode(s, sum);
        return sum[0];
    }

	private void decode(String s, int[] sum) {
		if (s.length() == 0) {
			++sum[0];
			return;
		}
		decode(s.substring(1), sum);
		if (s.length() > 1) {
			String str = s.substring(0, 2);
			if (Integer.valueOf(str) <= 26) {
				decode(s.substring(2), sum);
			}
		}
	}
}
