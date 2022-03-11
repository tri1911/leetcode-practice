package others;

/**
 * Date: March 10, 2022
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 */

public class P206 {
    // time: O(n)
    // space: O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode();
        ListNode last = helper(dummy, head);
        last.next = null;
        return dummy.next;
    }

    private ListNode helper(ListNode dummy, ListNode current) {
        if (current.next == null) {
            dummy.next = current;
        } else {
            ListNode prev = helper(dummy, current.next);
            prev.next = current;
        }
        return current;
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
