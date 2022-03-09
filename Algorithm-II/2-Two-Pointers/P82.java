package algorithm2.twoPointers;

/**
 * date: Dec 14, 2021 - redo on March 08, 2022
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

public class P82 {
    // first attempt
    // time: O(n)
    // space: O(1)
    public static ListNode _deleteDuplicates(ListNode head) {
        if (head == null) return null;
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

    // redo on March 08, 2022
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, current = head;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) current = current.next;
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        P82 obj = new P82();
        
        int[] nums = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = obj.createList(nums);
        System.out.println("Expect: [1,2,5]. Received: " + obj.printList(obj.deleteDuplicates(head)));

        nums = new int[]{1, 1, 1, 2, 3};
        head = obj.createList(nums);
        System.out.println("Expect: [2,3]. Received: " + obj.printList(obj.deleteDuplicates(head)));

        nums = new int[]{1, 1};
        head = obj.createList(nums);
        System.out.println("Expect: []. Received: " + obj.printList(obj.deleteDuplicates(head)));

        nums = new int[]{1, 2, 2};
        head = obj.createList(nums);
        System.out.println("Expect: [1]. Received: " + obj.printList(obj.deleteDuplicates(head)));
    }

    private ListNode createList(int[] nums) {
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

    private String printList(ListNode head) {
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

/**
 * reference
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/
 */