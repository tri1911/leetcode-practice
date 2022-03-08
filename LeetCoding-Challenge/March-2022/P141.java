package leetcodingchallenge.march2022;

/**
 * Date: March 08, 2022
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 */

public class P141 {
    // use Floyd's cycle detection algorithm
    // time: O(n)
    // space: O(1)
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode tortoise = head, hore = head.next;
        while (hore != null && hore.next != null) {
            if (tortoise == hore) return true;
            tortoise = tortoise.next;
            hore = hore.next.next;
        }
        return false;
    }

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
