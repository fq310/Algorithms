package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class JumpGameIITest {

	@Test
	public void test() {
		JumpGameII j = new JumpGameII();
		assertEquals(j.jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}), 2);
	}

}
