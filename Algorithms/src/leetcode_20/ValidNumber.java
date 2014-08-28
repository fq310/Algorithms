package leetcode_20;

public class ValidNumber {
    public boolean isNumber(String s) {
    	s = s.trim();
    	return s.matches("[+-]?[0-9]*\\.[0-9]+") || s.matches("[+-]?[0-9]+\\.?") ||
    			s.matches("[+-]?[0-9]*\\.[0-9]+[eE][+-]?[0-9]+[f]?") ||
    			s.matches("[+-]?[0-9]+\\.?[eE][+-]?[0-9]+[f]?");
    }
}
