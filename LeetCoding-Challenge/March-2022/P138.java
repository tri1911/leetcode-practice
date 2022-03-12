package leetcodingchallenge.march2022;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: March 12, 2022
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer
 */

public class P138 {
    // own solution using Hash Table
    // time: O(n)
    // space: O(n)
    public Node _copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> hash = new HashMap<>();
        Node current = head;
        // first pass: clone linked-list without populating the "next" & "random" pointers yet
        while (current != null) {
            hash.put(current, new Node(current.val));
            current = current.next;
        }
        // second pass: populate the random pointers
        current = head;
        while (current != null) {
            Node cloneNode = hash.get(current);
            cloneNode.next = hash.get(current.next);
            cloneNode.random = hash.get(current.random);
            current = current.next;
        }
        return hash.get(head);
    }

    // optimized solution without hash table
    // time: O(n)
    // space: O(1)
    public Node copyRandomList(Node head) {
        //base case
        if (head == null) return null;
        Node current = head;
        // 1st pass: inserts new cloned nodes between original nodes
        while (current != null) {
            Node next = current.next;
            current.next = new Node(current.val);
            current.next.next = next;
            // move forward
            current = next;
        }
        // 2nd pass: populates `random` pointers for cloned nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            // move forward
            current = current.next.next;
        }
        // final pass: extracts cloned nodes
        current = head;
        Node ans = head.next;
        Node currentClone = ans;
        while (currentClone.next != null) {
            current.next = current.next.next;
            current = current.next;
            currentClone.next = currentClone.next.next;
            currentClone = currentClone.next;
        }
        current.next = null; // OR: current.next.next;
        return ans;
    }

    // Definition for a Node.
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

/**
 * reference
 * https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
 * https://www.youtube.com/watch?v=EHpS2TBfWQg
 */
