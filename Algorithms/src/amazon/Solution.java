package amazon;

import java.util.HashMap;
import java.util.Map;
/*
Given an integer between 0 - 999,999, print an English sentence that describes the integer, for example, input 10, the output is ten
Note:
Each word should be lower case, for example, one hundred and twenty, and there should be one and only one space between each word

Samples


input:
1
output:
one

input:
23
output:
twenty three

input:
105
output:
one hundred and five

input:
12345
output:
twelve thousand three hundred and forty five

input:
123456
output:
one hundred and twenty three thousand four hundred and fifty six
 */
public class Solution {
	public static void main(String[] args) {
		printNumber(1);
		printNumber(23);
		printNumber(105);
		printNumber(12345);
		printNumber(123456);
		printNumber(100000);
		printNumber(100001);
		printNumber(100100);
		printNumber(100010);
		printNumber(10001);
		printNumber(10101);
		printNumber(10100);
	}
	 
	private static void printNumber(int num) {
		if (num < 0 || num > 999999) return;
		StringBuilder buffer = new StringBuilder();
		String result;
		if (num > 999) {
			buffer.append(parseNumber(num / 1000));
			buffer.append(" thousand ");
			String hundredNum = (parseNumber(num % 1000));
			if (hundredNum.endsWith("hundred")) {
				result = buffer.toString().trim() + " and " + hundredNum;
			} else {
				result = buffer.toString().trim() + " " + hundredNum;
			}
			if (result.startsWith("and"))
				result = result.substring(3).trim();
			if (result.endsWith(" and") && !result.endsWith("thousand"))
				result = result.substring(0, result.length() - 3).trim();
		} else {
			buffer.append(parseNumber(num));
			result = buffer.toString().trim();
			if (result.startsWith("and"))
				result = result.substring(3).trim();
			if (result.endsWith("and"))
				result = result.substring(0, result.length() - 3).trim();
		}
		System.out.println(result);
	}

	private static String parseNumber(int num) {
		Map<Integer, String> numberMap1 = new HashMap<Integer, String>();
		numberMap1.put(1, "one");
		numberMap1.put(2, "two");
		numberMap1.put(3, "three");
		numberMap1.put(4, "four");
		numberMap1.put(5, "five");
		numberMap1.put(6, "six");
		numberMap1.put(7, "seven");
		numberMap1.put(8, "eight");
		numberMap1.put(9, "nine");
		
		Map<Integer, String> numberMap2 = new HashMap<Integer, String>();
		numberMap2.put(11, "eleven");
		numberMap2.put(12, "twelve");
		numberMap2.put(13, "thirteen");
		numberMap2.put(14, "fourteen");
		numberMap2.put(15, "fifteen");
		numberMap2.put(16, "sixteen");
		numberMap2.put(17, "seventeen");
		numberMap2.put(18, "eighteen");
		numberMap2.put(19, "nineteen");
		numberMap2.put(0, "");
		Map<Integer, String> numberMap3 = new HashMap<Integer, String>();
		numberMap3.put(1, "ten");
		numberMap3.put(2, "twenty");
		numberMap3.put(3, "thirty");
		numberMap3.put(4, "forty");
		numberMap3.put(5, "fifty");
		numberMap3.put(6, "sixty");
		numberMap3.put(7, "seventy");
		numberMap3.put(8, "eighty");
		numberMap3.put(9, "ninety");
		
		StringBuilder buffer = new StringBuilder();
		int hundredNumber = num / 100;
		if (numberMap1.get(hundredNumber) != null) {
			buffer.append(" " + numberMap1.get(hundredNumber) + " hundred");
		}
		int tenNumber = num % 100;
		if (tenNumber > 0) {
			buffer.append(" and");
			if (numberMap2.get(tenNumber) != null) {
				buffer.append(" " + numberMap2.get(tenNumber));
			} else {
				tenNumber = (num % 100) / 10;
				if (numberMap3.get(tenNumber) != null) {
					buffer.append(" " + numberMap3.get(tenNumber));
				}
				int oneNumber = (num % 100) % 10;
				if (numberMap1.get(oneNumber) != null) {
					buffer.append(" " + numberMap1.get(oneNumber));
				}
			}
		}
		return buffer.toString().trim();
	}
}