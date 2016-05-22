package leetcode_152;

import java.util.Stack;

/**
 * Created by zhangchen on 16/5/22.
 * remember to reset the "min" value when the minStack is empty again
 * and reset the min value when "pop" a value
 */
public class Problem155 {
    //remember to reset the "min" value when the minStack is empty again
    //and reset the min value when "pop" a value
    private class Node {
        int value;
        Node next;
        Node pre;
    }
    private Node head = new Node();
    private Node tail = new Node();
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public Problem155() {
        head.next = tail;
        tail.pre = head;
    }

    public void push(int x) {
        Node node = new Node();
        node.value = x;
        node.next = head.next;
        node.pre = head;
        head.next = node;

        if (node.value <= min) {
            min = node.value;
        }
        minStack.push(min);
    }

    public void pop() {
        if (head.next == tail) return;
        Node node = head.next;
        head.next = node.next;
        node.next.pre = head;

        minStack.pop();
        if (minStack.empty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = minStack.peek();
        }
    }

    public int top() {
        if (head.next == tail) return 0;
        return head.next.value;
    }

    public int getMin() {
        if (minStack.empty()) return 0;
        return minStack.peek();
    }
}
