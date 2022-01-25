package leetcodingchallenge.january2022;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: Jan 10, 2022
 * 1022. Sum of Root To Leaf Binary Numbers
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */

// TODO: implement optimized solution with constant space using Morris Preorder Traversal

public class P1022 {
    // Recursive pre-order traversal
    // time: O(n) & space: O(height)
    private int rootToLeaf = 0;

    public int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }

    private void preorder(TreeNode head, int current) {
        if (head == null) return;
        current = (current << 1) | head.val; // OR = current * 2 + 1
        if (head.left == null && head.right == null) rootToLeaf += current;
        preorder(head.left, current);
        preorder(head.right, current);
    }

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

/*  Iterative preorder
    public int sumRootToLeaf(TreeNode root) {
        int rootToLeaf = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            root = current.getKey();
            int val = current.getValue();

            if (root != null) {
                val = (val << 1) | root.val;
                if (root.left == null && root.right == null) {
                    rootToLeaf += val;
                } else {
                    stack.push(new Pair<>(root.left, val));
                    stack.push(new Pair<>(root.right, val));
                }
            }
        }
        return rootToLeaf;
    }
 */

/**
 * reference
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/solution
 * https://www.youtube.com/watch?v=wGXB9OWhPTg
 */
