package leetcodingchallenge.august2022;

/**
 * Date: August 12, 2022
 * 235. Lowest Common Ancestor of a Binary Search Tree (Already solve in C++ before in Dec 2021)
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */

public class P235 {
    // time: O(log(n))
    // space: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    // Definition for a binary tree node.
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
