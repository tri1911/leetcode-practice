package leetcodingchallenge.september2022;

/**
 * Date: September 05, 2022
 * 814. Binary Tree Pruning
 * https://leetcode.com/problems/binary-tree-pruning/
 */

public class P814 {
    // recursive, dfs approach
    // time & space: O(n)
    public TreeNode pruneTree(TreeNode root) {
        return invalidTree(root) ? null : root;
    }

    // helper function to check whether the subtree contains only 0's
    private boolean invalidTree(TreeNode node) {
        if (node == null) return true;
        boolean left = invalidTree(node.left);
        boolean right = invalidTree(node.right);
        if (left) node.left = null;
        if (right) node.right = null;
        return node.val == 0 && left && right;
    }

    // Definition for a binary tree node.
    private class TreeNode {
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
