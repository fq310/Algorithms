package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {

	@Test
	public void test() {
		RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
		int[] a = new int[]{1, 1, 2};
		assertEquals(r.removeDuplicates(a), 2);
		Assert.assertArrayEquals(a, new int[]{1, 2, 2});
		
		a = new int[]{1, 1, 2, 2};
		assertEquals(r.removeDuplicates(a), 2);
		Assert.assertArrayEquals(a, new int[]{1, 2, 2, 2});
		
		a = new int[]{-1,0,0,0,0,3,3};
		assertEquals(r.removeDuplicates(a), 3);
		Assert.assertArrayEquals(a, new int[]{-1,0,3,3,0,3,3});
		
		a = new int[]{1, 2};
		assertEquals(r.removeDuplicates(a), 2);
		Assert.assertArrayEquals(a, new int[]{1, 2});
		
		a = new int[]{1, 1};
		assertEquals(r.removeDuplicates(a), 1);
		Assert.assertArrayEquals(a, new int[]{1, 1});
	}

}
