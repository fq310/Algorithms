package amazon;

import java.util.ArrayList;
import java.util.List;

/*
Question 1 / 2
Given an array A, find the maximum neighboring-peak-valley difference of A,  MaxD(A).
For example, A={2, 3, 6, 5, 7, 9}, the elements 2, 5 could be regarded as the valley while 6 and 9 are the peaks. The difference of each neighboring peak-valley pair could be enumerated as below:
D[2, 6]=4, D[6,5]=1, D=[5,9]=4.
Thus, MaxD(A)=4.
Please write a program to find the maximum neighboring-peak-valley difference of an array. The input contains several lines(10 lines at most), and each line contains of several numbers separated by space. We treat every line an array.And each line has 2 numbers at least and 20 numbers at most.
The output should be the maximum neighboring-peak-valley difference of the arrays and separated by comma. For example:
Input:
2 3 6 5 7 9
2 3 6 5 7
2 3 6 5 7 9 10
Output:
4,4,5
 */
public class Question002 {

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);a1.add(3);a1.add(6);a1.add(5);a1.add(7);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(2);a2.add(3);a2.add(6);a2.add(5);a2.add(7);a2.add(9);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(2);a3.add(3);a3.add(6);a3.add(5);a3.add(7);a3.add(10);
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(2);a4.add(3);
		ArrayList<Integer> a5 = new ArrayList<Integer>();
		a5.add(2);a5.add(2);
		ArrayList<Integer> a6 = new ArrayList<Integer>();
		a6.add(2);a6.add(1);a6.add(3);
		ArrayList<Integer> a7 = new ArrayList<Integer>();
		a7.add(2);a7.add(2);a7.add(2);
		ArrayList<Integer> a8 = new ArrayList<Integer>();
		a8.add(2);a8.add(3);a8.add(2);
		ArrayList<Integer> a9 = new ArrayList<Integer>();
		a9.add(2);a9.add(2);a9.add(3);
		ArrayList<Integer> a10 = new ArrayList<Integer>();
		a10.add(2);a10.add(1);
		input.add(a1);
		input.add(a2);
		input.add(a3);
		input.add(a4);
		input.add(a5);
		input.add(a6);
		input.add(a7);
		input.add(a8);
		input.add(a9);
		input.add(a10);
		findMaxDistanceArray(input);
	}
	
	public static void findMaxDistanceArray(List<List<Integer>> input) {
		StringBuilder result = new StringBuilder();
		for (List<Integer> array : input) {
			result.append(findMaxDistance(array)).append(",");
		}
		result.deleteCharAt(result.length() - 1);
		System.out.println(result.toString());
	}

	private static Integer findMaxDistance(List<Integer> array) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < array.size(); ++i) {
			if (i == 0 || i == array.size() - 1) {
				result.add(array.get(i));
				continue;
			}
			if ((array.get(i) > array.get(i - 1) && array.get(i) > array.get(i + 1)) ||
					(array.get(i) < array.get(i - 1) && array.get(i) < array.get(i + 1))) {
				result.add(array.get(i));
			}
		}
		int maxDistance = 0;
		for (int i = 1; i < result.size(); ++i) {
			int distance = Math.abs(result.get(i) - result.get(i - 1));
			if (distance > maxDistance) maxDistance = distance;
		}
		return maxDistance;
	}

}
