package leetcodingchallenge.april2022;

/**
 * Date: April 17, 2022
 * 897. Increasing Order Search Tree
 * https://leetcode.com/problems/increasing-order-search-tree/
 */

// TODO: implement use List

public class P897 {
    private TreeNode current;

    // time: O(n)
    // space: O(H) where H is the height of the BST
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode();
        current = dummy;
        inorder(root);
        return dummy.right;
    }

    // inorder (left -> node -> right) traversal - relink the node along the way
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            // remove the link to the left child
            node.left = null;
            // relink
            current.right = node;
            // move the current to the next one
            current = node; // or = current.right;
            inorder(node.right);
        }
    }

    //  Definition for a binary tree node.
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
 * https://leetcode.com/problems/increasing-order-search-tree/solution/
 */