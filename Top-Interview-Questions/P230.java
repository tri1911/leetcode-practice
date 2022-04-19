package topInterviewQs;

import java.util.*;

/**
 * Date: Jan 9, 2022 - Redo on April 17, 2022
 * 230. the Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */

// TODO: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
// TODO: use max heap?

public class P230 {
    /*  Approach 1: recursive in-order traversal with extra array
        // time complexity: O(n)
        // space complexity: O(n)
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> sorted = new ArrayList<>();
            inorder(root, sorted);
            return sorted.get(k - 1);
        }

        private void inorder(TreeNode head, List<Integer> current) {
            if (head == null) return;
            inorder(head.left, current);
            current.add(head.val);
            inorder(head.right, current);
        }
     */

    // Approach 2: Iterative Inorder Traversal
    // time complexity: O(height + k)
    // space complexity: O(height)
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (--k == 0) return current.val;
            current = current.right;
        }
        return -1;
    }

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, one, null);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3, two, four);
        TreeNode six = new TreeNode(6);
        TreeNode root = new TreeNode(5, three, six);

        P230 obj = new P230();
        System.out.println("Expected: 3. Received: " + obj.kthSmallest(root, 3));
    }
}

/**
 * reference
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
 */