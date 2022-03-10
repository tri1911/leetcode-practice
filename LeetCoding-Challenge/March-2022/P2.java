package leetcodingchallenge.march2022;

/**
 * Date: March 10, 2022
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 */

public class P2 {
    // my own solution using 2 pointers - similar to the official solution
    // time: O(n)
    // space: O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int sum = 0, carry = 0;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            // compute
            int val1 = p1 != null ? p1.val : 0;
            int val2 = p2 != null ? p2.val : 0;
            sum = val1 + val2 + carry;
            carry = sum / 10;
            // set the next digit
            current.next = new ListNode(sum % 10);
            // move forward
            current = current.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (carry == 1) current.next = new ListNode(1);
        return dummy.next;
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

/**
 * solution
 * https://leetcode.com/problems/add-two-numbers/solution/
 */