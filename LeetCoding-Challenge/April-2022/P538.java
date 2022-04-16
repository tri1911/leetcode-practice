package leetcodingchallenge.april2022;

/**
 * Date: April 16, 2022
 * 538. Convert BST to Greater Tree
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */

// TODO: implement use iterative approach + Optimized solution - Morris inorder traversal

public class P538 {
    // global sum state to record the sum of nodes so far
    private int sum = 0;

    // time: O(n)
    // space: O(n)
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    // Definition for a binary tree node.
    public class TreeNode {
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
}

/**
 * reference
 * https://leetcode.com/problems/convert-bst-to-greater-tree/solution/
 */