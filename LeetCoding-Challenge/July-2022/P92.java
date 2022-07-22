package leetcodingchallenge.july2022;

/**
 * Date: July 21, 2022
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */

public class P92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return null;
    }

    //Definition for singly-linked list.
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
