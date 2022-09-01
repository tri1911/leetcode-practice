package leetcodingchallenge.september2022;

/**
 * Date: September 01, 2022
 * 1448. Count Good Nodes in Binary Tree
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */

public class P1448 {
    private int count;

    public int goodNodes(TreeNode root) {
        count = 0;
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    private void dfs(TreeNode node, int max) {
        if (node != null) {
            if (node.val >= max) this.count++;
            dfs(node.left, Math.max(max, node.val));
            dfs(node.right, Math.max(max, node.val));
        }
    }

    //    Definition for a binary tree node.
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
