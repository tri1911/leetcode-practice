package topInterviewQs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: April 05, 2022
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */

// TODO: check out whether there exists better approach

public class P103 {
    // time: O(n)
    // space: O(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                if (leftToRight) {
                    TreeNode current = queue.removeFirst();
                    list.add(current.val);
                    if (current.left != null) queue.addLast(current.left);
                    if (current.right != null) queue.addLast(current.right);
                } else {
                    TreeNode current = queue.removeLast();
                    list.add(current.val);
                    if (current.right != null) queue.addFirst(current.right);
                    if (current.left != null) queue.addFirst(current.left);
                }
            }
            leftToRight = !leftToRight;
            ans.add(list);
        }
        return ans;
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
