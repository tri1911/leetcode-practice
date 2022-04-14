package leetcodingchallenge.april2022;

/**
 * Date: April 14, 2022
 * 700. Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */

public class P700 {
    // time: O(log(n))
    // space: O(1)
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null) {
            if (current.val == val) return current;
            current = current.val > val ? current.left : current.right;
        }
        return null;
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
