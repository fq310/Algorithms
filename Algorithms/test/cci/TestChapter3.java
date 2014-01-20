package cci;


import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;


public class TestChapter3 {
	@Test
	public void test3_2() {
		MinStack stack  = new MinStack();
		Integer node5 = stack.push(5);
		Assert.assertTrue(node5 == stack.getMinNode());
		
		stack.push(6);
		Assert.assertTrue(node5 == stack.getMinNode());
		
		Integer node3 = stack.push(3);
		Assert.assertTrue(node3 == stack.getMinNode());
		
		stack.push(7);
		Assert.assertTrue(node3 == stack.getMinNode());
		
		stack.pop();
		Assert.assertTrue(node3 == stack.getMinNode());
		
		stack.pop();
		Assert.assertTrue(node5 == stack.getMinNode());
		
		stack.pop();
		Assert.assertTrue(node5 == stack.getMinNode());
	}
	
	@Test
	public void test3_3() {
		for (int i = 1; i < 10; ++i) {
			SetOfStacks<Integer> stack = new SetOfStacks<Integer>(i);
			testSetStack(stack);
		}
	}

	private void testSetStack(SetOfStacks<Integer> stack) {
		Stack<Integer> testStack = new Stack<>();
		for (int i = 1; i <= 10; ++i) {
			for (int j = i; j <= 10; ++j) {
				Integer item = new Integer(j);
				testStack.push(item);
				stack.push(item);
			}
			while (!testStack.isEmpty())
				Assert.assertTrue(stack.pop() == testStack.pop());
		}
	}
	
	@Test
	public void test3_4() {
		for (int i = 3; i <= 20; ++i) {
			Tower t1 = new Tower(i);
			Tower t2 = new Tower(0);
			Tower t3 = new Tower(0);
			Chapter3 ch3 = new Chapter3();
			ch3.hanoiMove(t1, t2, t3, i);
			StringBuilder moveResult = new StringBuilder();
			for (int j = 1; j <= i; ++j) {
				moveResult.append(j);
			}
			assertTrue(getStackString(t3.getStack()).equals(moveResult.toString()));
		}
	}
	
	@Test
	public void test3_5() {
		MyQueue<Integer> queue = new MyQueue<>();
		Queue<Integer> testQueue = new LinkedList<>();
		for (int i = 1; i <= 10; ++i) {
			for (int j = i; j <= 10; ++j) {
				Integer item = new Integer(j);
				testQueue.add(item);
				queue.add(item);
			}
			while (!testQueue.isEmpty())
				Assert.assertTrue(queue.poll() == testQueue.poll());
		}
	}
	
	@Test
	public void test3_6() {
		Chapter3 ch3 = new Chapter3();
		Stack<Item> stack = createStack(new int[]{1});
		ch3.sort(stack);
		Assert.assertTrue(getStackString(stack).equals("1"));
		
		stack = createStack(new int[]{2, 1});
		ch3.sort(stack);
		Assert.assertTrue(getStackString(stack).equals("21"));
		
		stack = createStack(new int[]{1, 2});
		ch3.sort(stack);
		Assert.assertTrue(getStackString(stack).equals("21"));
		
		stack = createStack(new int[]{1, 2, 3});
		ch3.sort(stack);
		Assert.assertTrue(getStackString(stack).equals("321"));
		
		stack = createStack(new int[]{3, 2, 1});
		ch3.sort(stack);
		Assert.assertTrue(getStackString(stack).equals("321"));
		
		stack = createStack(new int[]{1, 2, 2});
		ch3.sort(stack);
		Assert.assertTrue(getStackString(stack).equals("221"));
		
		stack = createStack(new int[]{1, 2, 2, 4});
		ch3.sort(stack);
		Assert.assertTrue(getStackString(stack).equals("4221"));
		
		stack = createStack(new int[]{4, 2, 2, 2});
		ch3.sort(stack);
		Assert.assertTrue(getStackString(stack).equals("4222"));
	}

	private String getStackString(Stack<? extends Object> stack) {
		StringBuilder stackString = new StringBuilder();
		while (!stack.isEmpty()) {
			stackString.append(stack.pop());
		}
		return stackString.toString();
	}

	private Stack<Item> createStack(int[] data) {
		Stack<Item> stack = new Stack<>();
		for (int i : data) {
			stack.push(new Item(i));
		}
		return stack;
	}
}
