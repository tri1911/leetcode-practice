package others;

/**
 * Date: Feb 21, 2022
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
 */

public class P404 {
    // time: O(n)
    // space: O(1)
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int left = root.left != null && root.left.left == null && root.left.right == null ? root.left.val : sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        return left + right;
        // can write it in 1 line if you want, but it's quite long and hard to read
        // return root == null ? 0 : (root.left != null && root.left.left == null && root.left.right == null ? root.left.val : sumOfLeftLeaves(root.left)) + sumOfLeftLeaves(root.right);
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
