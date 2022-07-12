package leetcodingchallenge.july2022;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Date: July 11, 2022
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */

public class P199 {
    // first attempt using breadth-first search approach
    // time: O(n)
    // space:O(1)
    public List<Integer> _rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.pollFirst();
                if (i == n - 1) ans.add(current.val);
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return ans;
    }

    // another approach with depth-first search, recursion (brilliant idea)

    private List<Integer> ans;

    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        dfs(0, root);
        return ans;
    }

    private void dfs(int level, TreeNode node) {
        if (node != null) {
            if (ans.size() == level) ans.add(node.val);
            dfs(level + 1, node.right);
            dfs(level + 1, node.left);
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
