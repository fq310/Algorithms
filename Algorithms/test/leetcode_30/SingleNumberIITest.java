package leetcode_30;

import static org.junit.Assert.*;
import leetcode_30.SingleNumberII;

import org.junit.Test;

public class SingleNumberIITest {

	@Test
	public void test() {
		SingleNumberII s = new SingleNumberII();
		assertEquals(s.singleNumber(new int[]{1,1,1,2}), 2);
		assertEquals(s.singleNumber(new int[]{1,1,1,3,3,3,2}), 2);
	}

}
