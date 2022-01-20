package leetcodingchallenge.january2022;

/**
 * Date: Jan 19, 2022
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */

// TODO: find optimized implementation & Review the proof of Floyd Algorithm

public class P142 {
    // use Hare and Tortoise - Floyd's Algorithm
    // time: O(n)
    // space: O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // find the meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
