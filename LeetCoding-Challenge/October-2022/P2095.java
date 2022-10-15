package leetcodingchallenge.october2022;

/**
 * Date: Oct 14, 2022
 * 2095. Delete the Middle Node of a Linked List
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */

// TODO: check-out the official solution

public class P2095 {
    // my own approach
    // time: O(n)
    // space: O(1)
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = new ListNode(0, head);
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return fast == head ? null : head;
    }

    // Definition for singly-linked list.
    private class ListNode {
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

/**
 * Reference
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/solution/
 */