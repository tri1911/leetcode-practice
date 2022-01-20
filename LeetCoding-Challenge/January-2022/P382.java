package leetcodingchallenge.january2022;

// Date: Jan 7, 2022
// 382. Linked List Random Node
// https://leetcode.com/problems/linked-list-random-node/

// TODO: really good solution, need to review

public class P382 {
    private ListNode head;

    public P382(ListNode head) {
        this.head = head;
    }

    // use "reservoir sampling" algorithm
    // time complexity: O(n)
    // space complexity: O(1)

    // each time an element is considered, the probability to be chosen:
    // P(be chosen to put in the reservoir) = k * (1 / i) where 1 / i is simulated using Math.random() * i
    // P(not be replaced) = 1 - P(be replaced at jth element) = 1 - (1 / j) = j - 1 / j
    // => P = (k / i) * (i / i + 1) * (i + 1 / i + 2) * ... * (n - 1 / n) = k / n
    // we chose k = 1 => all elements have 1 / n probability to be chosen at last
    public int getRandom() {
        ListNode cur = this.head;
        int i = 1, ans = 0;
        while (cur != null) {
            // decide whether the current node be put to the reservoir
            if (Math.random() * i < 1.0)
                ans = cur.val;
            // move to the next node
            i++;
            cur = cur.next;
        }
        return ans;
    }

    public static class ListNode {
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

    public static void main(String[] args) {
        P382 obj = new P382(new ListNode());
        System.out.println("Random get: " + obj.getRandom());
        System.out.println("Random get: " + obj.getRandom());
        System.out.println("Random get: " + obj.getRandom());
    }
}

// reference
// https://leetcode.com/problems/linked-list-random-node/solution/