package others;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Date: April 18, 2022 - Redo: Sept 07, 2022
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
 */

public class P94 {
    // 1 - iterative inorder traversal
    // time & space: O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            ans.add(current.val);
            current = current.right;
        }
        return ans;
    }

    // 2 - Morris Traversal
    // time: O(n)
    // space: O(1)
    public List<Integer> _inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode current = root;
        TreeNode pred;
        while (current != null) {
            if (current.left != null) {
                // find the most-right node in the left subtree of the current node
                pred = current.left;
                while (pred.right != null) pred = pred.right;
                // make the current node the right child of the right-most node
                pred.right = current;
                // erase the left pointer of the current node
                TreeNode tmp = current.left;
                current.left = null;
                // iterate to the tmp node
                current = tmp;
            } else {
                ans.add(current.val);
                current = current.right;
            }
        }
        return ans;
    }

    // 3 - Recursive approach (Redo on Sept 07, 2022)
    private List<Integer> ans;

    public List<Integer> __inorderTraversal(TreeNode root) {
        ans = new ArrayList();
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            ans.add(node.val);
            inorder(node.right);
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

/**
 * reference
 * https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
 */