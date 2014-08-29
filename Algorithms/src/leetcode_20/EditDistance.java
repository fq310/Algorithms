package leetcode_20;

public class EditDistance {
    public int minDistance(String word1, String word2) {
    	int length1 = word1.length();
		int length2 = word2.length();
    	if (length1 == 0 || length2 == 0)
    		return length1 > length2 ? length1 : length2;
		int result[][] = new int[length1 + 1][length2 + 1];
    	for (int i = 0; i < result.length; ++i) {
    		result[i][0] = i;
    	}
    	for (int i = 0; i < result[0].length; ++i) {
    		result[0][i] = i;
    	}
    	
    	for (int i = 1; i < result.length; ++i) {
    		for (int j = 1; j < result[0].length; ++j) {
    			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
    				result[i][j] = result[i - 1][j - 1];
    			} else {
    				result[i][j] = Math.min(Math.min(result[i - 1][j] + 1, result[i][j - 1] + 1), result[i - 1][j - 1] + 1);
    			}
    		}
    	}
    	
        return result[word1.length()][word2.length()];
    }
}
