import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private int size;
	private Node first;
	private Node last;
	private class Node {
		Item item;
		Node next;
		Node pre;
	}
	
	public Deque() {
		first = null;
		last  = null;
		size = 0;
	}
	public boolean isEmpty() {
		// is the deque empty?
		return size == 0;
	}
	public int size() {
		// return the number of items on the deque
		return size;
	}
	public void addFirst(Item item){
		// insert the item at the front
		throwExceptionAtNullItem(item);
		Node newNode = new Node();
		newNode.item = item;
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			newNode.next = first;
			first.pre = newNode;
			first = newNode;
		}
		++size;
	}

	public void addLast(Item item) {
		// insert the item at the end
		throwExceptionAtNullItem(item);
		Node newNode = new Node();
		newNode.item = item;
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			newNode.pre = last;
			last = newNode;
		}
		++size;
	}
	public Item removeFirst() {
		// delete and return the item at the front
		throwExceptionAtEmptyList();
		Item item = first.item;
		first = first.next;
		if (first == null) {
			last = null;
		} else {
			first.pre = null;
		}
		--size;
		return item;
	}

	public Item removeLast() {
		throwExceptionAtEmptyList();
		Item item = last.item;
		last = last.pre;
		if (last == null) {
			first = null;
		} else {
			last.next = null;
		}
		--size;
		return item;
	}
	
	private void throwExceptionAtEmptyList() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
	}
	
	private void throwExceptionAtNullItem(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
	}
	// return an iterator over items in order from front to end
	 @Override
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	 
	 private class DequeIterator implements Iterator<Item> {
		 private Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		 
	 }
	 
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
	}
	 
	 public static void main(String args[]) {
		 Deque<Integer> queue = new Deque<Integer>();
//		 queue.removeFirst();
//		 queue.removeLast();
		 
		 queue.addFirst(1);
		 queue.removeFirst();
		 queue.addLast(2);
		 queue.removeLast();
		 queue.addFirst(1);
		 queue.removeLast();
		 queue.addLast(2);
		 queue.removeFirst();
		 
		 queue.addLast(3);
		 queue.addLast(4);
		 queue.removeFirst();
		 queue.removeFirst();
		 
		 queue.addFirst(3);
		 queue.addFirst(4);
		 queue.removeLast();
		 queue.removeLast();
	 }

}
