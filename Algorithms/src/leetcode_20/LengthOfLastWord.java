package leetcode_20;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
    	if (s == null) return 0;
    	StringBuilder buffer = new StringBuilder();
    	int i = s.length() - 1;
    	while (i >=0 && s.charAt(i) == ' ') --i;
    	for (; i >= 0; --i) {
    		char charr = s.charAt(i);
			if (charr == ' ') break;
			buffer.insert(0, charr);
    	}
    	return buffer.length();
    }
}
