package topInterviewQs;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: March 02, 2022
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

public class P105 {
    // preorder: root -> left -> right
    // inorder: left -> root -> right

    Map<Integer, Integer> hash;
    int preorderIdx;

    // time: O(n)
    // space: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIdx = 0;
        hash = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) hash.put(inorder[i], i);
        return buildTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int first, int last) {
        if (last < first) return null;
        int rootVal = preorder[preorderIdx++];
        int rootIdx = hash.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, first, rootIdx - 1);
        root.right = buildTree(preorder, rootIdx + 1, last);
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

/**
 * reference
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/
 */