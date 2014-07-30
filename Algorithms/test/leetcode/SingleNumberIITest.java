package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleNumberIITest {

	@Test
	public void test() {
		SingleNumberII s = new SingleNumberII();
		assertEquals(s.singleNumber(new int[]{1,1,1,2}), 2);
		assertEquals(s.singleNumber(new int[]{1,1,1,3,3,3,2}), 2);
	}

}
