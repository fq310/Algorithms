package cci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestChapter2 {
	private Chapter2<Integer> ch2;
	@Before
	public void before() {
		ch2 = new Chapter2<Integer>();
	}
	
	@Test
	public void test2_1() {
		Node<Integer> list = createLinklist();
		String oldValue = getListValue(list);
		ch2.removeDuplicate(list);
		String newValue = getListValue(list);
		Assert.assertTrue(!oldValue.equals(newValue));
	}
	
	@Test
	public void test2_2() {
		Node<Integer> list = createLinklist();
		Node<Integer> target = ch2.findElement(list, 3);
		Assert.assertTrue(target.value.equals(6));
	}
	
	@Test
	public void test2_3() {
		Node<Integer> list = createLinklist();
		Node<Integer> node = list;
		for (int i = 0; i < 3; ++i) {
			node = node.next;
		}
		ch2.deleteTarget(node);
		String newValue = getListValue(list);
		Assert.assertTrue(newValue.equals("014618"));
	}
	
	@Test
	public void test2_4() {
		test2_4Template(new int[]{7, 6, 5}, 5, "567");
		test2_4Template(new int[]{6, 6, 6, 8}, 4, "6668");
		test2_4Template(new int[]{6, 6, 6, 8}, 8, "6668");
		test2_4Template(new int[]{6, 6, 6, 8}, 6, "6668");
		test2_4Template(new int[]{1, 8, 2, 9, 3, 10, 4, 11}, 5, "1234891011");
	}
	
	private void test2_4Template(int[] data, int midValue, String orderedStr) {
		Node<Integer> list = createList(data);
		ch2.partition(list, midValue);
		String newValue = getListValue(list);
		Assert.assertTrue(newValue.equals(orderedStr));
	}

	public Node<Integer> createList(int[] data) {
		Node<Integer> node = new Node<Integer>();
		Node<Integer> head = node;
		for (int i : data) {
			node.next = new Node<Integer>();
			node = node.next;
			node.value = i;
		}
		return head.next;
	}
	
	private Node<Integer> createLinklist() {
		return createList(new int[]{0, 1, 4, 1, 6, 1, 8});
	}
	
	private String getListValue(Node<Integer> list) {
		if (list == null) return "";
		Node<Integer> node = list;
		StringBuilder result = new StringBuilder();
		while (node != null) {
			result.append(node.value);
			node = node.next;
		}
		return result.toString();
	}

}
