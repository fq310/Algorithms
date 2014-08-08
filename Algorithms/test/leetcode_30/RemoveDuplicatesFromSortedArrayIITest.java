package leetcode_30;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayIITest {

	@Test
	public void test() {
		RemoveDuplicatesFromSortedArrayII r = new RemoveDuplicatesFromSortedArrayII();
		int[] a = new int[]{1,1,1,2,2,3};
		assertEquals(r.removeDuplicates(a), 5);
		Assert.assertArrayEquals(a, new int[]{1,1,2,2,3, 3});
		
		
		a = new int[]{1,1,1};
		assertEquals(r.removeDuplicates(a), 2);
		Assert.assertArrayEquals(a, new int[]{1,1,1});
		
		a = new int[]{1,1,2,2};
		assertEquals(r.removeDuplicates(a), 4);
		Assert.assertArrayEquals(a, new int[]{1,1,2,2});
	}

}
