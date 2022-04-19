package leetcodingchallenge.april2022;

/**
 * Date: April 19, 2022
 * 99. Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/
 */

// TODO: do the follow up using Morris Traversal - time: O(n) & space: O(1)

public class P99 {
    private TreeNode pred, first, second;

    // time: O(n)
    // space: O(n)
    public void recoverTree(TreeNode root) {
        // initialization
        pred = first = second = null;
        // traverse through the BST to detect the node with wrong place
        inorder(root);
        // swap
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            // go to left subtree
            inorder(node.left);
            // main process
            if (pred != null && !(pred.val <= node.val)) {
                if (first == null) first = pred;
                if (first != null) second = node;
            }
            pred = node;
            // go to right subtree
            inorder(node.right);
        }
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

/**
 * test cases
 * [1,3,null,null,2]
 * [3,1,4,null,null,2]
 * [2,3,1]
 */

/**
 * reference
 * https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
 * https://leetcode.com/problems/recover-binary-search-tree/discuss/1278113/Come-on-in!-No-explanation-can-be-more-straightforward-than-graph-for-this-problem
 */