package others;

/**
 * Date: April 16, 2022
 * 1038. Binary Search Tree to Greater Sum Tree -  the same as Problem 538
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */

public class P1038 {
    private int sum = 0;

    // time & space: O(n)
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
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
