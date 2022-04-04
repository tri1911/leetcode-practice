package leetcodingchallenge.april2022;

/**
 * Date: April 04, 2022
 * 1721. Swapping Nodes in a Linked List
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */

// TODO: checkout whether there is another better solution

public class P1721 {
    // use 2 pointer approach
    // time: O(n)
    // space: O(1)
    public ListNode swapNodes(ListNode head, int k) {
        // determine the kth node from the start
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) fast = fast.next;
        // save the kth node from the start into `first` variable
        ListNode first = fast;
        // determine the kth node from the end
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // swap values
        int tmp = first.val;
        first.val = slow.val;
        slow.val = tmp;
        return head;
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
