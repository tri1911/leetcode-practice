package leetcodingchallenge.june2022;

/**
 * Date: Fri, June 17, 2022
 * 968. Binary Tree Cameras
 * https://leetcode.com/problems/binary-tree-cameras/
 */

public class P968 {
    // time: O(n)
    // space: O(log(n))
    public int minCameraCover(TreeNode root) {
        int[] ans = solve(root);
        return Math.min(ans[1], ans[2]);
    }

    // state 0: covered by parent
    // state 1: covered by children
    // state 2: cover by itself
    private int[] solve(TreeNode current) {
        // base case
        if (current == null) return new int[]{0, 0, 1_001};
        // recursively compute children subtrees
        int[] left = solve(current.left);
        int[] right = solve(current.right);
        int mL12 = Math.min(left[1], left[2]);
        int mR12 = Math.min(right[1], right[2]);
        // compute for the current node (based on its children)
        int[] states = new int[3];
        states[0] = left[1] + right[1];
        states[1] = Math.min(left[2] + mR12, right[2] + mL12);
        states[2] = 1 + Math.min(left[0], mL12) + Math.min(right[0], mR12);
        return states;
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

/**
 * references
 * https://leetcode.com/problems/binary-tree-cameras/solution/
 */