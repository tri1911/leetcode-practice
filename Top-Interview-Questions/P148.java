package topInterviewQs;

// Date: Dec 28, 2021
// 148. Sort List
// https://leetcode.com/problems/sort-list/

public class P148 {
    // merge sort
    // time complexity: O(nlog(n))
    // space complexity: O(1)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode first = sortList(head);
        ListNode second = sortList(mid);
        return merge(first, second);
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }
        tail.next = (first != null) ? first : second;
        return dummy.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode prev = null;
        while (head != null && head.next != null) {
            prev = (prev == null) ? head : prev.next;
            head = head.next.next;
        }
        ListNode mid = prev.next;
        prev.next = null;
        return mid;
    }

    public static void main(String[] args) {
        P148 obj = new P148();
        ListNode head = new ListNode(4);
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(3);
        head.next = p1;
        p1.next = p2;
        p2.next = p3;
        ListNode result = obj.sortList(head);
        System.out.println(result);
    }

    static public class ListNode {
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
// https://leetcode.com/problems/sort-list/discuss/46714/Java-merge-sort-solution
// https://www.youtube.com/watch?v=pNTc1bM1z-4

/* https://leetcode.com/problems/sort-list/solution/
public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
 */