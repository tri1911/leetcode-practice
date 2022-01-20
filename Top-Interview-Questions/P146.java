package topInterviewQs;

/**
 * Date: Jan 20, 2022
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 */

// TODO: read the better implementation

import java.util.HashMap;
import java.util.Map;

// data structure used: Hash Table for constant retrieval & Doubly Linked-List for removal
// time: O(1) for put and get operations
// space: O(n)
public class P146 {
    private int capacity;
    private Node head, tail;
    private Map<Integer, Node> dict = new HashMap<>();

    public P146(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        Node node = dict.get(key);
        if (node != null) {
            // move to front
            remove(node);
            insertFront(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (dict.containsKey(key)) { // if existing, move the node with key to the front
            Node existingNode = dict.get(key);
            existingNode.val = value; // update new value for existing node
            remove(existingNode); // remove from the current position
            insertFront(existingNode); // insert at front
        } else { // otherwise, add node to the front, update capacity & if capacity is over, remove tail node
            Node newNode = new Node(key, value, null, null); // initialization
            insertFront(newNode); // insert at front
            dict.put(key, newNode); // records to the hash table
            // if current capacity equals 0, remove the least recently used node
            if (this.capacity - 1 < 0) {
                // remove tail node from hash table
                dict.remove(this.tail.key);
                // remove tail from the doubly linked-list
                removeTail();
            } else
                this.capacity--;
        }
        System.out.println("hash table: " + dict);
    }

    /**
     * Doubly Linked-List implementation
     */

    private class Node {
        Node next, previous;
        int key, val;

        public Node(int key, int val, Node previous, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.previous = previous;
        }
    }

    // insert node at front
    private void insertFront(Node node) {
        if (this.head != null)
            this.head.previous = node;
        else
            this.tail = node; // update tail pointer
        node.previous = null;
        node.next = this.head;
        this.head = node; // update head pointer
    }

    // remove in middle
    private void remove(Node node) {
        // edge cases
        if (node.previous == null) // if node is the head
            this.head = node.next;
        if (node.next == null) // if node is the tail
            this.tail = node.previous;
        // remove node from current position
        if (node.previous != null)
            node.previous.next = node.next;
        if (node.next != null)
            node.next.previous = node.previous;
    }

    // remove node at back
    private void removeTail() {
        // cause list length >= 1 when removing the tail, don't need to cover the case tail is null
        this.tail = this.tail.previous;
        if (this.tail != null)
            this.tail.next = null;
        else
            this.head = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 * <p>
 * reference
 * https://www.youtube.com/watch?v=S6IfqDXWa10&t=415s
 * https://github.com/backtobackswe/backtobackswe-solutions/blob/master/Linked%20Lists/LRUCache/LRUCache.java
 */