package others;

/**
 * Date: March 27, 2022
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */

public class P543 {
    private int ans = Integer.MIN_VALUE;

    // time: O(n) where n = # of nodes in the tree
    // space: O(1)
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return ans;
    }

    // helper function to calculate the depth of a subtree & update the longest path at the same time
    private int getDepth(TreeNode head) {
        if (head == null) return -1;
        int left = getDepth(head.left);
        int right = getDepth(head.right);
        // the longest path passing a node = 2 + the depth of left child + the depth of right child
        ans = Math.max(ans, 2 + left + right);
        return 1 + Math.max(left, right);
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
 * https://leetcode.com/problems/diameter-of-binary-tree/discuss/101132/Java-Solution-MaxDepth
 */