package others;

/**
 * Date: April 17, 2022
 * 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */

public class P114 {
    private TreeNode current = new TreeNode();

    // time: O(n)
    // space: O(H) where H is the height of BST
    public void flatten(TreeNode root) {
        if (root != null) {
            // record the left & right subtree
            TreeNode left = root.left;
            TreeNode right = root.right;
            // remove the left link of the current node
            root.left = null;
            // link
            current.right = root;
            // move the current node forward
            current = root;
            // recursively call on the left & right subtrees
            flatten(left);
            flatten(right);
        }
    }

    //Definition for a binary tree node.
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
