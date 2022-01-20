package topInterviewQs;

// Date: Jan 5, 2022
// 23. Merge k Sorted Lists
// https://leetcode.com/problems/merge-k-sorted-lists/

// this problem is similar to the problem 378

import java.util.PriorityQueue;
import java.util.Queue;

// TODO: check out whether there is another optimized solution

public class P23 {
    // time complexity: O(n * log(k)) where n is the total elements in k lists
    // space complexity: O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        Queue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < k; i++) {
            if (lists[i] != null)
                heap.add(lists[i]);
        }
        while (!heap.isEmpty()) {
            current.next = heap.poll();
            current = current.next;
            if (current.next != null)
                heap.add(current.next);
        }
        return dummy.next;
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
// https://leetcode.com/problems/merge-k-sorted-lists/solution/
// https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
// https://www.youtube.com/watch?v=ptYUCjfNhJY&t=29s
// https://stackoverflow.com/questions/11003155/change-priorityqueue-to-max-priorityqueue