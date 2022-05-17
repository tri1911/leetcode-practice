package leetcodingchallenge.may2022;

/**
 * Date: May 17, 2022
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 */

// TODO: check out the official solution

public class P1379 {
    // recursive approach
    // time: O(h)
    // space: O(h)
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) return left;
        return getTargetCopy(original.right, cloned.right, target);
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

/**
 * references
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/solution/
 */