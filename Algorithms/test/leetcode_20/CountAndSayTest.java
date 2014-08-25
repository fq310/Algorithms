package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountAndSayTest {

	@Test
	public void test() {
		CountAndSay c =  new CountAndSay();
		assertEquals(c.countAndSay(1), "1");
		assertEquals(c.countAndSay(2), "11");
		assertEquals(c.countAndSay(3), "21");
		assertEquals(c.countAndSay(4), "1211");
		assertEquals(c.countAndSay(5), "111221");
	}

}
