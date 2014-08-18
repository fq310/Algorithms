package leetcode_20;

import static org.junit.Assert.*;
import leetcode.util.ListUtil;

import org.junit.Test;

public class AddTwoNumbersTest {

	@Test
	public void test() {
		AddTwoNumbers a = new AddTwoNumbers();
		assertEquals(a.addTwoNumbers(ListUtil.createList(new int[]{2,4,3}), ListUtil.createList(new int[]{5,6,4})).toString(), "7");
		assertEquals(a.addTwoNumbers(ListUtil.createList(new int[]{8,9,9}), ListUtil.createList(new int[]{2})).toString(), "0");
	}

}
