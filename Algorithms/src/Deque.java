import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private int size;
	private Item first;
	private Item last;
	public Deque() {
		// construct an empty deque
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
	}
	private void throwExceptionAtNullItem(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
	}
	public void addLast(Item item) {
		// insert the item at the end
		throwExceptionAtNullItem(item);
	}
	public Item removeFirst() {
		// delete and return the item at the front
		throwExceptionAtEmptyList();
		return null;
	}
	private void throwExceptionAtEmptyList() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
	}
	public Item removeLast() {
		throwExceptionAtEmptyList();
		return null;
	}
	// return an iterator over items in order from front to end
	 @Override
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	 
	 private class DequeIterator implements Iterator<Item> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		 
	 }

}
