package leetcodingchallenge.august2022;

/**
 * Date: August 11, 2022
 * 98. Validate Binary Search Tree (already solve this problem in C++ before)
 * https://leetcode.com/problems/validate-binary-search-tree/
 */

public class P98 {
    // time:
    // space:
    public boolean isValidBST(TreeNode root) {

        return true;
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
