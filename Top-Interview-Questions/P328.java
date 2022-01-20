package topInterviewQs;

// Date: Jan 6, 2022
// 328. Odd Even Linked List
// https://leetcode.com/problems/odd-even-linked-list/

public class P328 {
    /*  First Attempt
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode head_odd = head;
            ListNode head_even = head.next;
            ListNode cur_odd = head_odd;
            ListNode cur_even = head_even;
            while (cur_odd.next != null && cur_even.next != null) {
                cur_odd.next = cur_even.next;
                cur_odd = cur_odd.next;
                if (cur_even.next.next != null) {
                    cur_even.next = cur_even.next.next;
                    cur_even = cur_even.next;
                }
            }
            cur_odd.next = head_even;
            cur_even.next = null;
            return head_odd;
        }
     */

    // refactor
    // time complexity: O(n)
    // space complexity: O(1)
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next; // or = odd.next.next
            odd = odd.next;
            even.next = odd.next; // or = even.next.next
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    private static class ListNode {
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

// reference
// https://leetcode.com/problems/odd-even-linked-list/solution/
