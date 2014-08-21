package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImplementStrStrTest {

	@Test
	public void test() {
		ImplementStrStr i = new ImplementStrStr();
		assertEquals(i.strStr("gldssglsssdvdse", "ss"), "ssglsssdvdse");
		assertEquals(i.strStr("gldssglsssdvdse", "gl"), "gldssglsssdvdse");
		assertEquals(i.strStr("gldssglsssdvdse", "se"), "se");
	}

}
