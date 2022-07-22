package leetcodingchallenge.july2022;

/**
 * Date: July 21, 2022
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */

 // TODO: check out the iterative implementation within the official solution when have some time

public class P92 {
    private ListNode leftPointer;
    private boolean stopSwapping;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        this.leftPointer = head;
        return null;
    }

    private void backtracking(ListNode rightPointer, int left, int right) {
        // base case: right pointer is in desired position, so we stop moving it
        if (right == 1) return;

        // move the left pointer towards the start point to swap
        if (left > 1) leftPointer = leftPointer.next;
        // move the right pointer towards the end point to swap
        rightPointer = rightPointer.next;

        backtracking(rightPointer, left - 1, right - 1);

        if (leftPointer == rightPointer || rightPointer.next = leftPointer) stopSwapping = true;

        if (!stopSwapping) {
            // swapping
            int tmp = leftPointer.val;
            leftPointer.val = rightPointer.val;
            rightPointer.val = tmp;
            // after that, move the left pointer forward
            leftPointer = leftPointer.next;
        }
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
 * references
 * https://leetcode.com/problems/reverse-linked-list-ii/solution/
 */