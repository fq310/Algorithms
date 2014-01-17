package programmingpearls1.ch2;

public class Rotation {

	private String str;

	public Rotation(String str) {
		this.str = str;
	}

	public String leftRotate(int i) {
		int rotationCount = i % str.length();
		if (rotationCount == 0) return new String(str);
		String leftStr = str.substring(0, rotationCount);
		String rightStr = str.substring(rotationCount, str.length());
		leftStr = reverse(leftStr);
		rightStr = reverse(rightStr);
		return reverse(leftStr + rightStr);
	}

	private String reverse(String leftStr) {
		StringBuilder result = new StringBuilder();
		for (int i = leftStr.length() - 1; i >= 0; --i) {
			result.append(leftStr.charAt(i));
		}
		return result.toString();
	}

}
