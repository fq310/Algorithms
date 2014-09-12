package leetcode_20;

import org.junit.Test;

public class CopyListWithRandomPointerTest {

	@Test
	public void test() {
		CopyListWithRandomPointer c = new CopyListWithRandomPointer();
		RandomListNode r = new RandomListNode(1);
		c.copyRandomList(r);
	}

}
