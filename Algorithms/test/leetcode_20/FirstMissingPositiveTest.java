package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstMissingPositiveTest {

	@Test
	public void test() {
		FirstMissingPositive f = new FirstMissingPositive();
		assertEquals(f.firstMissingPositive(new int[]{1,2,0}), 3);
		assertEquals(f.firstMissingPositive(new int[]{1,1}), 2);
		assertEquals(f.firstMissingPositive(new int[]{}), 1);
		assertEquals(f.firstMissingPositive(new int[]{1}), 2);
		assertEquals(f.firstMissingPositive(new int[]{1,2}), 3);
		assertEquals(f.firstMissingPositive(new int[]{3,4,-1,1}), 2);
	}

}
