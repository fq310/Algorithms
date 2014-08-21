package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class NextPermutationTest {

	@Test
	public void test() {
		NextPermutation n = new NextPermutation();
		int[] a = new int[]{1,2,3};
		n.nextPermutation(a);
		assertArrayEquals(a, new int[]{1,3,2});
		a = new int[]{3,2,1};
		n.nextPermutation(a);
		assertArrayEquals(a, new int[]{1,2,3});
		a = new int[]{1,1,5};
		n.nextPermutation(a);
		assertArrayEquals(a, new int[]{1,5,1});
		a = new int[]{1,5,1};
		n.nextPermutation(a);
		assertArrayEquals(a, new int[]{5,1,1});
		a = new int[]{5,1,1};
		n.nextPermutation(a);
		assertArrayEquals(a, new int[]{1,1,5});
	}
}
