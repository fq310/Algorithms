import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node first;
    private Node last;
    private class Node {
        private Item item;
        private Node next;
        private Node pre;
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
        public Node getPre() {
            return pre;
        }
        public void setPre(Node pre) {
            this.pre = pre;
        }
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
    public void addFirst(Item item) {
        // insert the item at the front
        throwExceptionAtNullItem(item);
        Node newNode = new Node();
        newNode.setItem(item);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPre(newNode);
            first = newNode;
        }
        ++size;
    }

    public void addLast(Item item) {
        // insert the item at the end
        throwExceptionAtNullItem(item);
        Node newNode = new Node();
        newNode.setItem(item);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPre(last);
            last = newNode;
        }
        ++size;
    }
    public Item removeFirst() {
        // delete and return the item at the front
        throwExceptionAtEmptyList();
        Item item = first.getItem();
        first = first.getNext();
        if (first == null) {
            last = null;
        } else {
            first.setPre(null);
        }
        --size;
        return item;
    }

    public Item removeLast() {
        throwExceptionAtEmptyList();
        Item item = last.getItem();
        last = last.getPre();
        if (last == null) {
            first = null;
        } else {
            last.setNext(null);
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
            if (current == null) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
         
     }
}
