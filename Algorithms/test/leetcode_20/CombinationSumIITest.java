package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombinationSumIITest {

	@Test
	public void test() {
		CombinationSumII c = new CombinationSumII();
		assertEquals(c.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8).toString(), "[[1, 2, 5], [1, 1, 6], [2, 6], [1, 7]]");
	}

}
