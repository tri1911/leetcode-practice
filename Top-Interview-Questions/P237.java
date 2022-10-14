package topInterviewQs;

/**
 * Date: Jan 8, 2022 - Redo: Oct 13, 2022
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */

public class P237 {
    // time & space: O(1)
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /*  first attempt
        // time complexity: O(n)
        // space complexity: O(1)
        public void deleteNode(ListNode node) {
            ListNode prev = null, cur = node;
            while (cur != null && cur.next != null) {
                cur.val = cur.next.val;
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
        }
     */

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

/**
 * Reference
 * https://leetcode.com/problems/delete-node-in-a-linked-list/discuss/65455/1-3-lines-C%2B%2BJavaPythonCCJavaScriptRuby
 */