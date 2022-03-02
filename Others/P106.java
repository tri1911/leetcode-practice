package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: March 02, 2022
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */

public class P106 {
    // postorder: left -> right -> root
    // can go in reverse order: root -> right -> left
    // go from right -> left of postorder array
    // inorder: left -> root -> right
    private int postorderIdx;
    private Map<Integer, Integer> hash;

    // time: O(n)
    // space: O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        postorderIdx = n - 1;
        hash = new HashMap<>();
        for (int i = 0; i < n; i++) hash.put(inorder[i], i);
        return buildTree(postorder, 0, n - 1);
    }

    public TreeNode buildTree(int[] postorder, int first, int last) {
        if (first > last) return null;
        int rootVal = postorder[postorderIdx--];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = hash.get(rootVal);
        root.right = buildTree(postorder, rootIdx + 1, last);
        root.left = buildTree(postorder, first, rootIdx - 1);
        return root;
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
