package leetcodingchallenge.september2022;

/**
 * Date: September 07, 2022
 * 606. Construct String from Binary Tree
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */

public class P606 {
    private StringBuilder ans;

    public String tree2str(TreeNode root) {
        this.ans = new StringBuilder();
        preorder(root);
        return this.ans.toString();
    }

    private void preorder(TreeNode node) {
        this.ans.append(node.val);

        if (node.left != null) {
            this.ans.append('(');
            preorder(node.left);
            this.ans.append(')');
        } else if (node.right != null) {
            this.ans.append("()");
        }

        if (node.right != null) {
            this.ans.append('(');
            preorder(node.right);
            this.ans.append(')');
        }
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
