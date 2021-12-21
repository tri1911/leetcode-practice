package algorithm2.twoPointers;

// date: Dec 14, 2021
// 82. Remove Duplicates from Sorted List II
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

// time complexity: O(n)
// space complexity: O(1)
public class P82 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = new ListNode(0, head);
        ListNode fast = head;
        while (fast.next != null) {
            // found the duplicate node -> keep moving the current pointer
            // until finding the node with different value
            if (slow.next.val == fast.next.val) {
                while (fast.next != null && fast.next.val == slow.next.val) {
                    fast = fast.next;
                }
                if (slow.next == head) {
                    head = fast.next;
                }
                slow.next = fast.next;
                if (fast.next == null) {
                    return head;
                }
            } else {
                slow = fast;
            }
            fast = fast.next;
        }
        return head;
    }

    // TODO: Redo with the Leetcode solution (using Sentinel Head + Predecessor approach)
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/
    public ListNode deleteDuplicatesSolution(ListNode head) {
        // sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // skip all duplicates
                pred.next = head.next;
                // otherwise, move predecessor
            } else {
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = createList(nums);
        System.out.println("Expect: [1,2,5]. Received: " + printList(deleteDuplicates(head)));

        nums = new int[]{1, 1, 1, 2, 3};
        head = createList(nums);
        System.out.println("Expect: [2,3]. Received: " + printList(deleteDuplicates(head)));

        nums = new int[]{1, 1};
        head = createList(nums);
        System.out.println("Expect: []. Received: " + printList(deleteDuplicates(head)));

        nums = new int[]{1, 2, 2};
        head = createList(nums);
        System.out.println("Expect: [1]. Received: " + printList(deleteDuplicates(head)));
    }

    private static ListNode createList(int[] nums) {
        ListNode head = null;
        ListNode current = null;
        for (int value : nums) {
            if (current == null) {
                head = new ListNode(value);
                current = head;
            } else {
                current.next = new ListNode(value);
                current = current.next;
            }
        }
        return head;
    }

    private static String printList(ListNode head) {
        ListNode current = head;
        String output = "[";
        while (current != null) {
            output += current.val + (current.next != null ? "," : "");
            current = current.next;
        }
        output += "]";
        return output;
    }

    static class ListNode {
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

