package leetcodingchallenge.april2022;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: April 20, 2022
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */

public class P173 {
    // space: O(h) where h is the BST height
    private Deque<TreeNode> stack;
    private TreeNode cur;

    public P173(TreeNode root) {
        stack = new ArrayDeque<>();
        cur = root;
        // takes O(h) time
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    // time: O(1) in average
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    // time: O(1)
    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
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
