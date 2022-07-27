package topInterviewQs;

/**
 * Date: Feb 10, 2022 - Redo on July 26, 2022 (Daily Leetcode challenge)
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

// TODO: check out other approaches in the official solution

public class P236 {
    // use depth-first search approach
    // time: O(n) where n is the number of tree nodes
    // space: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q) return root;
        // general case
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null && right == null) return null;
        return left != null ? left : right;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

/**
 * reference
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
 */