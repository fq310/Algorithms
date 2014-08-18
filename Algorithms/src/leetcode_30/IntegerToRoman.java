package leetcode_30;

public class IntegerToRoman {
    public String intToRoman(int num) {
    	String result = "";
    	result += parseNumber(num / 1000, "M", "", "");
    	num = num % 1000;
    	result += parseNumber(num / 100, "C", "D", "M");
    	num = num % 100;
    	result += parseNumber(num / 10, "X", "L", "C");
    	num = num % 10;
    	result += parseNumber(num, "I", "V", "X");
        return result;
    }

	private String parseNumber(int value, String one, String five, String ten) {
		if (value == 0) return "";
		if (value == 4) return one + five;
		if (value == 9) return one + ten;
		if (value > 4) {
			int times = value - 5;
			String result = five;
			while (times > 0) {
				result += one;
				--times;
			}
			return result;
		}
		if (value < 4) {
			String result = "";
			while (value > 0) {
				result += one;
				--value;
			}
			return result;
		}
		return "";
	}
}
