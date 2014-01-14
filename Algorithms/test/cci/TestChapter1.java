package cci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestChapter1 {
	private Chapter1 ch1;
	
	@Before
	public void initial() {
		ch1 = new Chapter1();
	}
	
	@Test
	public void test1_1() {
		String a = "abcd";
		String b = "aad";
		Assert.assertTrue(ch1.isAllUnique(a));
		Assert.assertTrue(!ch1.isAllUnique(b));
	}
	
	@Test
	public void test1_2() {
		String a = "god   ";
		String b = "dog";
		Assert.assertTrue(!ch1.isPermuatation(a, b));
		String c = "abc";
		String d = "cba";
		Assert.assertTrue(ch1.isPermuatation(c, d));
		String e = "abc";
		String f = "abc";
		Assert.assertTrue(ch1.isPermuatation(e, f));
	}
	
	@Test
	public void test1_7() {
		int[][] a = new int[3][4];
		a[0] = new int[]{1, 0, 3, 4};
		a[1] = new int[]{1, 2, 3, 4};
		a[2] = new int[]{1, 2, 3, 0};
		ch1.setZeros(a);
		int[][] b = new int[3][4];
		b[0] = new int[]{0, 0, 0, 0};
		b[1] = new int[]{1, 0, 3, 0};
		b[2] = new int[]{0, 0, 0, 0};
		Assert.assertArrayEquals(a[0], b[0]);
		Assert.assertArrayEquals(a[1], b[1]);
		Assert.assertArrayEquals(a[2], b[2]);
		Assert.assertArrayEquals(a, b);
	}
	
	@Test
	public void test1_8() {
		String a1 = "waterbottle";
		String b1 = "erbottlewat";
		Assert.assertTrue(ch1.isRotation(a1, b1));
		String a2 = "tanke";
		String b2 = "tagke";
		Assert.assertTrue(!ch1.isRotation(a2, b2));
		
		
	}
}
