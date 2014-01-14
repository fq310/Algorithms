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
		Node<Integer> list = createNoRepeatlist();
		ch2.partition(list, 5);
		String newValue = getListValue(list);
		Assert.assertTrue(newValue.equals("014618"));
	}
	
	private Node<Integer> createLinklist() {
		Node<Integer> head = new Node<Integer>();
		head.value = 0;
		head.addToTail(1);
		head.addToTail(4);
		head.addToTail(1);
		head.addToTail(6);
		head.addToTail(1);
		head.addToTail(8);
		return head;
	}
	
	private Node<Integer> createNoRepeatlist() {
		Node<Integer> head = new Node<Integer>();
		head.value = 1;
		head.addToTail(8);
		head.addToTail(2);
		head.addToTail(9);
		head.addToTail(3);
		head.addToTail(10);
		head.addToTail(4);
		return head;
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
