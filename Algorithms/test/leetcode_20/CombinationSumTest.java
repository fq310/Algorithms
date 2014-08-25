package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombinationSumTest {

	@Test
	public void test() {
		CombinationSum c = new CombinationSum();
		assertEquals(c.combinationSum(new int[]{2, 3, 6, 7}, 7).toString(), "[[7], [2, 2, 3]]");
	}

}
