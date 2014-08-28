package leetcode_20;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddBinaryTest {

	@Test
	public void test() {
		AddBinary a = new AddBinary();
		assertEquals(a.addBinary("11", "1"), "100");
		assertEquals(a.addBinary("1", "1"), "10");
		assertEquals(a.addBinary("1", "0"), "1");
		assertEquals(a.addBinary("1111", "1111"), "11110");
	}

}
