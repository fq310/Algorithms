package cci;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Chapter3 {

	public void sort(Stack<Item> stack) {
		Stack<Item> sortedStack = new Stack<Item>();
		Item maxItem = stack.peek();
		int unSortedItemNumber = getStackNumer(stack);
		while (unSortedItemNumber > 0) {
			while (!stack.isEmpty()) {
				Item item = stack.pop();
				if (item.id > maxItem.id) {
					maxItem = item;
				}
				sortedStack.push(item);
			}
			int itemNumber = unSortedItemNumber;
			while (itemNumber > 0) {
				Item item = sortedStack.pop();
				if (item != maxItem) {
					stack.push(item);
				}
				--itemNumber;
			}
			sortedStack.push(maxItem);
			if (!stack.isEmpty()) maxItem = stack.peek();
			--unSortedItemNumber;
		}
		while (!sortedStack.isEmpty()) {
			stack.push(sortedStack.pop());
		}
	}

	private int getStackNumer(Stack<Item> stack) {
		return stack.size();
	}

}

class Item {
	int id;

	public Item(int id) {
		this.id = id;
	}

	public int getValue() {
		return id;
	}

	public void setValue(int value) {
		this.id = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() != this.getClass()) return false;
		Item that = (Item) obj;
		return this.id == that.id;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(id).hashCode();
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
	
}

//3.2
class MinStack extends Stack<Integer> {
	private static final long serialVersionUID = 1L;
	
	private Stack<Integer> minStack = new Stack<Integer>();
	private Integer min;
	public Integer getMinNode() {
		return min;
	}
	
	@Override
	public synchronized Integer pop() {
		minStack.pop();
		min = minStack.peek();
		return super.pop();
	}
	@Override
	public Integer push(Integer item) {
		if (min == null || item < min) {
			min = item;
		}
		minStack.push(min);
		return super.push(item);
	}
}

//3.3
class SetOfStacks<T> {
	private int currentStackNumber = 0;
	private int stackSize;
	public SetOfStacks(int stackSize) {
		this.stackSize = stackSize;
		stacks.add(new Stack<T>());
	}

	private List<Stack<T>> stacks = new LinkedList<>();
	
	public T push(T node) {
		Stack<T> currentStack = stacks.get(currentStackNumber);
		if (currentStack.size() == stackSize) {
			stacks.add(new Stack<T>());
			++currentStackNumber;
			currentStack = stacks.get(currentStackNumber);
		}
		return currentStack.push(node);
	}
	
	public T pop() {
		Stack<T> currentStack = stacks.get(currentStackNumber);
		while (currentStack.isEmpty() && currentStackNumber >= 0) {
			--currentStackNumber;
			currentStack = stacks.get(currentStackNumber);
		}
		if (currentStackNumber < 0) {
			currentStackNumber = 0;
			return null;
		}
		return stacks.get(currentStackNumber).pop();
	}
	
	/**
	 * pop at the specific stack
	 * @param index must start from 0
	 * @return
	 */
	public T popAt(int index) {
		if (index > currentStackNumber) return null;
		return stacks.get(index).pop();
	}
}

//3.5
class MyQueue<T> {

	private Stack<T> addStack = new Stack<T>();
	private Stack<T> popStack = new Stack<T>();
	
	public void add(T item) {
		addStack.add(item);
	}

	public T poll() {
		while (!addStack.isEmpty()) {
			popStack.push(addStack.pop());
		}
		T popItem = popStack.pop();
		while (!popStack.isEmpty()) {
			addStack.push(popStack.pop());
		}
		return popItem;
	}
	
}