import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int size;
	private class Node {
		Item item;
		Node next;
	}
	public RandomizedQueue() {
		first = null;
		last  = null;
		size = 0;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return size;
	}
	public void enqueue(Item item) {
		if (item == null) throw new NullPointerException();
		Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
        	first = last;
        } else{
        	oldlast.next = last;
        	int randomIndex = StdRandom.uniform(1, size + 1);
        	exchangeToLast(randomIndex);
        }
        ++size;
	}
	
	private void exchangeToLast(int randomIndex) {
		int i = 1;
		Node target = first;
		while (i != randomIndex) {
			target = target.next;
			++i;
		}
		Item temp = target.item;
		target.item = last.item;
		last.item = temp;
	}
	
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        --size;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
	}
	
	public Item sample() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
	}
	
	public Iterator<Item> iterator() {
		return new ListIterator(); 
	}
	
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
    public static void main(String[] args) {
    	RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
    	q.enqueue(1);
//    	q.dequeue();
    	q.enqueue(2);
    	q.enqueue(3);
//    	q.dequeue();
//    	q.dequeue();
    	q.enqueue(4);
    	q.enqueue(5);
//    	q.dequeue();
    	q.enqueue(6);
    	q.enqueue(7);
    }
}
