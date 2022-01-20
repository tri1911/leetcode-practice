package topInterviewQs;

// Date: Jan 8, 2022
// 234. Palindrome Linked List
// https://leetcode.com/problems/palindrome-linked-list/

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
