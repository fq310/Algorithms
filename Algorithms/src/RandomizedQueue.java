import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;
    private Node sampleNode;
    private class Node {
        private Item item;
        private Node next;
        public Item getItem() {
            return item;
        }
        public void setItem(Item item) {
            this.item = item;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
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
        last.setItem(item);
        last.setNext(null);
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.setNext(last);
            int randomIndex = StdRandom.uniform(1, size + 2);
            exchangeToLast(randomIndex);
        }
        ++size;
    }
    
    private void exchangeToLast(int randomIndex) {
        int i = 1;
        Node target = first;
        while (i != randomIndex) {
            target = target.getNext();
            ++i;
        }
        Item temp = target.getItem();
        target.setItem(last.getItem());
        last.setItem(temp);
    }
    
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.getItem();
        first = first.getNext();
        --size;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }
    
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        if (sampleNode == null) sampleNode = first;
        Item item = sampleNode.getItem();
        sampleNode = sampleNode.getNext();
        return item;
    }
    
    public Iterator<Item> iterator() {
        return new ListIterator(); 
    }
    
    private class ListIterator implements Iterator<Item> {
        private Node current;
        private RandomizedQueue<Item> queue = new RandomizedQueue<Item>();
        public ListIterator() {
            Node node = first;
            while (node != null) {
                queue.enqueue(node.getItem());
                node = node.getNext();
            }
            current = queue.first;
        }
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.getItem();
            current = current.getNext(); 
            return item;
        }
    }
   
}
