package cci;

public class Chapter1 {
	//1.1
	public boolean isAllUnique(String a) {
		int R = 65535;
		if (a.length() > R) return false;
		boolean[] uniqueArray = new boolean[R];
		for (int i = 0; i < a.length(); ++i) {
			char character = a.charAt(i);
			if (uniqueArray[character] == false) {
				uniqueArray[character] = true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	//1.3
	public boolean isPermuatation(String a, String b) {
		int R = 65536;
		int[] used = new int[R];
		for (int i = 0; i < a.length(); ++i) {
			used[a.charAt(i)]++;
		}
		for (int i = 0; i < b.length(); ++i) {
			if (--used[b.charAt(i)] < 0) return false;
		}
		return true;
	}
	
	//1.4
	public void replace(char[] str, int length) {
		int spaceCount = 0;
		for (int i = 0; i < length; ++i) {
			if (str[i] == ' ') ++spaceCount;
		}
		
		int sumLength = spaceCount * 2 + length;
		for (int i = length - 1; i >=0; --i) {
			if (str[i] == ' ') {
				str[--sumLength] = '0';
				str[--sumLength] = '2';
				str[--sumLength] = '%';
			} else {
				str[--sumLength] = str[i];
			}
		}
		
	}
	
	//1.5
	public String compress(String str) {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < str.length(); ) {
			char start = str.charAt(i);
			int j = i + 1;
			while (j < str.length() && str.charAt(j) == start) {
				++j;
			}
			int count = j - i;
			buffer.append(start);
			if (count == 1) {
				buffer.append(1); 
			} else {
				buffer.append(count);
			}
			i = j;
		}
		String result = buffer.toString();
		return result.length() < str.length() ? result : str;
	}
	
	//1.7
	public void setZeros(int[][] matrix) {
		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];
		for (int i = 0; i < rows.length; ++i) {
			for (int j = 0; j < columns.length; ++j) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}
		
		for (int i = 0; i < rows.length; ++i) {
			for (int j = 0; j < columns.length; ++j) {
				if (rows[i] == true || columns[j] == true) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	//1.8
	public boolean isRotation(String source, String target) {
		if (source == null || target == null) return false;
		if (source.length() != target.length()) return false;
		String doubleSource = source + source;
		if (isSubstring(doubleSource, target)) return true;
		return false;
	}

	private boolean isSubstring(String doubleSource, String target) {
		return doubleSource.contains(target);
	}

	
}
