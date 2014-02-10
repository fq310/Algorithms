package cci;


import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestChapter11 {
	@Test
	public void test11_1() {
		test11_1Template(new int[]{0}, new int[]{});
		test11_1Template(new int[]{}, new int[]{0});
		test11_1Template(new int[]{1}, new int[]{0});
		test11_1Template(new int[]{0}, new int[]{1});
		test11_1Template(new int[]{1, 3}, new int[]{2, 4});
		test11_1Template(new int[]{1, 2}, new int[]{3, 4});
		test11_1Template(new int[]{2, 3}, new int[]{1, 4});
		test11_1Template(new int[]{3, 4}, new int[]{1, 2});
		test11_1Template(new int[]{1, 3, 4, 9}, new int[]{0, 2, 5, 6, 7, 8});
	}

	private void test11_1Template(int[] arrayA, int[] arrayB) {
		Chapter11 ch = new Chapter11();
		int[] a = createIntegerArray(arrayA, arrayA.length + arrayB.length);
		ch.mergeArray(a, arrayB);
		int[] sorted = getSortedArray(arrayA, arrayB);
		Assert.assertArrayEquals(sorted, a);
	}
	
	private int[] getSortedArray(int[] arrayA, int[] arrayB) {
		int[] arrayC = new int[arrayA.length + arrayB.length];
		System.arraycopy(arrayA, 0, arrayC, 0, arrayA.length);
		System.arraycopy(arrayB, 0, arrayC, arrayA.length, arrayB.length);
		Arrays.sort(arrayC);
		return arrayC;
	}

	private int[] createIntegerArray(int[] data, int size) {
		int[] array = new int[size];
		for (int i = 0; i < data.length; ++i) {
			array[i] = data[i];
		}
		return array;
	}
}
