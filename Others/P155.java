package others;

/**
 * Date: Feb 20, 2022
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 */

public class P155 {
    Node head;

    public P155() {
        this.head = null;
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, null, val);
        } else {
            head = new Node(val, head, Math.min(head.minVal, val));
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minVal;
    }

    private class Node {
        int val;
        int minVal;
        Node next;

        Node(int val, Node next, int minVal) {
            this.val = val;
            this.next = next;
            this.minVal = minVal;
        }
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */