package leetcode_20;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	if (num1 == null || num2 == null)
    		return "";
    	if (num1.equals("0") || num2.equals("0"))
    		return "0";
    	
    	int zeros = 0;
    	int[][] sum = new int[num1.length()][];
    	int[] num2Array = getIntArray(num2);
    	int maxLength = 0;
    	for (int i = num1.length() - 1; i >= 0; --i) {
    		sum[i] = multiply(Integer.parseInt(String.valueOf(num1.charAt(i))), num2Array, zeros);
    		reverse(sum[i]);
    		maxLength = Math.max(maxLength, sum[i].length);
    		zeros++;
    	}
        return getString(sum, maxLength);
    }
    
    private void reverse(int[] a) {
		int i = 0, j = a.length - 1;
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			++i; --j;
		}
	}

	private String getString(int[][] products, int maxLength) {
		int[] resultArray = new int[maxLength + 1];
		int carry = 0;
		for (int i = 0; i < resultArray.length - 1; ++i) {
			int sum = 0;
			for (int j = 0; j < products.length; ++j) {
				if (i < products[j].length) {
					sum += products[j][i];
				}
			}
			sum += carry;
			if (sum > 9) {
				resultArray[i] = sum % 10;
				carry = sum / 10;
			} else {
				resultArray[i] += sum;
				carry = 0;
			}
		}
		StringBuilder result = new StringBuilder();
		int startIndex = resultArray.length - 1;
		while (startIndex >= 0 && resultArray[startIndex] == 0) {
			--startIndex;
		}
		for (; startIndex >= 0; --startIndex) {
			result.append(resultArray[startIndex]);
		}
		
		return result.toString();
	}

	private int[] getIntArray(String num2) {
		int[] array = new int[num2.length()];
		for (int i = 0; i < num2.length(); ++i) {
			array[i] = Integer.parseInt(String.valueOf(num2.charAt(i)));
		}
		return array;
	}

	private int[] multiply(int num, int[] num2Array, int zeros) {
		int[] result = new int[num2Array.length + 1 + zeros];
		System.arraycopy(num2Array, 0, result, 1, num2Array.length);
		int carry = 0;
		for (int i = result.length - 1 - zeros; i >= 0; --i) {
			int value = result[i] * num;
			value += carry;
			if (value > 9) {
				result[i] = value % 10;
				carry = value / 10;
			} else {
				result[i] = value;
				carry = 0;
			}
		}
		if (carry != 0) {
			result[0] = carry;
		}
		return result;
	}
}
