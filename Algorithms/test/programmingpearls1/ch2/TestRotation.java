package programmingpearls1.ch2;

import junit.framework.Assert;

import org.junit.Test;

public class TestRotation {
	@Test
	public void testRotation() {
		String str = "abcdefg";
		Rotation r = new Rotation(str);
		Assert.assertTrue(r.leftRotate(1).equals("bcdefga"));
		Assert.assertTrue(r.leftRotate(2).equals("cdefgab"));
		Assert.assertTrue(r.leftRotate(3).equals("defgabc"));
		Assert.assertTrue(r.leftRotate(4).equals("efgabcd"));
		Assert.assertTrue(r.leftRotate(5).equals("fgabcde"));
		Assert.assertTrue(r.leftRotate(7).equals("abcdefg"));
		Assert.assertTrue(r.leftRotate(8).equals("bcdefga"));
	}
}
