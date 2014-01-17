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
		Node<Integer> head = ch2.partition(list, 5);
		String newValue = getListValue(head);
		Assert.assertTrue(newValue.equals("12348910"));
		
		list = createLinklist(new int[]{8, 8, 8, 8, 8});
		head = ch2.partition(list, 5);
		newValue = getListValue(head);
		Assert.assertTrue(newValue.equals("88888"));
		
		list = createLinklist(new int[]{});
		head = ch2.partition(list, 5);
		newValue = getListValue(head);
		Assert.assertTrue(newValue.equals(""));
		
		list = createLinklist(new int[]{1});
		head = ch2.partition(list, 5);
		newValue = getListValue(head);
		Assert.assertTrue(newValue.equals("1"));
		
		list = createLinklist(new int[]{3, 1});
		head = ch2.partition(list, 2);
		newValue = getListValue(head);
		Assert.assertTrue(newValue.equals("13"));
	}
	
	@Test
	public void test2_5() {
		Node<Integer> list1 = createLinklist(new int[]{7, 1, 6});
		Node<Integer> list2 = createLinklist(new int[]{5, 9, 2});
		Node<Integer> result = ch2.add(list1, list2);
		String newValue = getListValue(result);
		Assert.assertTrue(newValue.equals("219"));
		
		
		list1 = createLinklist(new int[]{8, 8});
		list2 = createLinklist(new int[]{2});
		result = ch2.add(list1, list2);
		newValue = getListValue(result);
		Assert.assertTrue(newValue.equals("09"));
		
		list1 = createLinklist(new int[]{1, 8, 8});
		list2 = createLinklist(new int[]{0});
		result = ch2.add(list1, list2);
		newValue = getListValue(result);
		Assert.assertTrue(newValue.equals("188"));
		
	}
	
	private Node<Integer> createLinklist() {
		return createLinklist(new int[]{0, 1, 4, 1, 6, 1, 8});
	}
	
	private Node<Integer> createNoRepeatlist() {
		return createLinklist(new int[]{1, 8, 2, 9, 3, 10, 4});
	}
	
	private Node<Integer> createLinklist(int[] data) {
		Node<Integer> node = new Node<Integer>();
		Node<Integer> head = node;
		for (int i : data) {
			node.next = new Node<Integer>();
			node = node.next;
			node.value = i;
		}
		return head.next;
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
