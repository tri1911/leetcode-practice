package leetcodingchallenge.july2022;

/**
 * Date: July 22, 2022
 * 86. Partition List
 * https://leetcode.com/problems/partition-list/
 */

public class P86 {
    // two-pointer approach
    // time: O(n)
    // space: O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode smallSentinel = new ListNode(), small = smallSentinel;
        ListNode bigSentinel = new ListNode(), big = bigSentinel;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = bigSentinel.next;
        return smallSentinel.next;
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
 * https://leetcode.com/problems/partition-list/solution/
 */