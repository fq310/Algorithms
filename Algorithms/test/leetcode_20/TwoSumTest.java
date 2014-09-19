package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoSumTest {

	@Test
	public void test() {
		TwoSum t = new TwoSum();
		assertArrayEquals(t.twoSum(new int[]{3, 2, 4}, 6), new int[]{2, 3});
		
		t = new TwoSum();
		assertArrayEquals(t.twoSum(new int[]{5, 75, 25}, 100), new int[]{2, 3});
	}

}
