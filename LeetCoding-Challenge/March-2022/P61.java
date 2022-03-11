package leetcodingchallenge.march2022;

/**
 * Date: March 11, 2022
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 */

// TODO: find the better implementation

public class P61 {
    // my own solution
    // time: O(n)
    // space: O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 1, count = k;
        ListNode slow = head, fast = head;
        while (count-- > 0 && fast.next != null) {
            fast = fast.next;
            len++;
        }
        if (fast.next == null) { // k >= len
            k %= len;
            for (int i = 1; i < len - k; i++)
                slow = slow.next;
        } else { // use 2 pointer technique
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    //  Definition for singly-linked list.
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