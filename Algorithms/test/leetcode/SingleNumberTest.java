package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleNumberTest {

	@Test
	public void test() {
		SingleNumber s = new SingleNumber();
		assertEquals(s.singleNumber(new int[]{1, 1, 3, 3, 4}), 4);
		assertEquals(s.singleNumber(new int[]{1}), 1);
	}

}
