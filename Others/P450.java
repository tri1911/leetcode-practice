package others;

/**
 * Date: April 19, 2022
 * 450. Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */

public class P450 {
    // time: O(log(n))
    // space: O(1)
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // search for the node to remove
        TreeNode parent = null;
        TreeNode node = root;
        while (node != null && node.val != key) {
            parent = node;
            node = node.val > key ? node.left : node.right;
        }
        if (node == null) return root;

        // delete
        if (node.left == null || node.right == null) { // has at most one child
            TreeNode replacedNode = node.left == null ? node.right : node.left;
            if (root == node) root = replacedNode;
            else if (parent.left == node) parent.left = replacedNode;
            else parent.right = replacedNode;
        } else { // has both children
            // locate the right-most node in the left subtree
            TreeNode pred = node;
            TreeNode tmp = node.left;
            while (tmp.right != null) {
                pred = tmp;
                tmp = tmp.right;
            }
            // set the node's key to the rightmost node's one
            node.val = tmp.val;
            // lift the left child of tmp to 1 level up
            if (pred == node) pred.left = tmp.left;
            else pred.right = tmp.left;
        }
        return root;
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
 * reference
 * Adam Drozdek's Text Book
 */
