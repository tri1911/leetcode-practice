package others;

/**
 * Date: Feb 16, 2022
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 */

public class P110 {
    // time: O(n)
    // space: O(h)
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode current) {
        if (current == null) return 0;
        int left = getHeight(current.left);
        if (left == -1) return -1;
        int right = getHeight(current.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

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
