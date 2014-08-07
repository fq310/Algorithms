package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.MergeSortedArray;

import org.junit.Test;

public class MergeSortedArrayTest {

	@Test
	public void test() {
		MergeSortedArray m = new MergeSortedArray();
		int[] a = new int[8];
		a[0] = 1;
		a[1] = 3;
		a[2] = 5;
		a[3] = 7;
		int[] b = new int[]{2, 4, 6, 8};
		m.merge(a, 4, b, 4);
		assertArrayEquals(a, new int[]{1,2,3,4,5,6,7,8});
	}

}
