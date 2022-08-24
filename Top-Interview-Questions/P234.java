package topInterviewQs;

/**
 * Date: Jan 8, 2022 - Redo: August 23, 2022
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 */

import java.util.Stack;

// TODO: implement the solution with constant space complexity

public class P234 {
    /*  use stack
        // time complexity: O(n)
        // space complexity: O(n)
        public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        int count = 0;
        while (current != null) {
            stack.push(current);
            current = current.next;
            count++;
        }
        for (int i = 0; i < count / 2; i++) {
            if (head.val != stack.pop().val)
                return false;
            head = head.next;
        }
        return true;
    }
     */

    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast, rev;
        slow = fast = head;
        rev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            // reversing the half
            ListNode tmp = rev;
            rev = slow;
            slow = slow.next;
            rev.next = tmp;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != rev.val) return false;
            slow = slow.next;
            rev = rev.next;
        }
        return true;
    }

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
 * References
 * https://leetcode.com/problems/palindrome-linked-list/discuss/64500/11-lines-12-with-restore-O(n)-time-O(1)-space
 */