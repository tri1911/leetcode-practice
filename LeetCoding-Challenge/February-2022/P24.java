package leetcodingchallenge.february2022;

/**
 * Date: Feb 16, 2022
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */

// TODO: check out another approach

public class P24 {
    // own solution
    // time: O(n)
    // space: O(1)
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = new ListNode(), second = head;
        head = head.next;
        while (second != null && second.next != null) {
            first.next = second.next;
            second.next = second.next.next;
            first.next.next = second;
            // update pointers
            first = second;
            second = second.next;
        }
        return head;
    }

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
