package leetcodingchallenge.february2022;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: Feb 27, 2022
 * 662. Maximum Width of Binary Tree
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */

public class P662 {
    // own solution
    // time: O(n)
    // space: O(n)
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        root.val = 1;
        queue.offer(root);
        int ans = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            int offset = 0;
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                if (i == 0) offset = current.val - 1;
                if (i == n - 1) ans = Math.max(ans, current.val - offset);
                if (current.left != null) {
                    current.left.val = (current.val - offset) * 2 - 1;
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    current.right.val = (current.val - offset) * 2;
                    queue.offer(current.right);
                }
            }
        }
        return ans;
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
