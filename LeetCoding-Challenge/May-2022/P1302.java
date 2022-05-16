package leetcodingchallenge.may2022;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: May 15, 2022
 * 1302. Deepest Leaves Sum
 * https://leetcode.com/problems/deepest-leaves-sum/
 */

public class P1302 {
    // Breadth-First Search approach
    // time: O(n)
    // space: O(n)
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode current;
        while (!queue.isEmpty()) {
            int n = queue.size();
            ans = 0;
            for (int i = 0; i < n; i++) {
                current = queue.poll();
                ans += current.val;
                if (current.right != null) queue.offer(current.right);
                if (current.left != null) queue.offer(current.left);
            }
        }
        return ans;
    }

    // Depth-First Search approach - quicker runtime in Leetcode result
    private int maxDepth, ans;

    public int _deepestLeavesSum(TreeNode root) {
        ans = maxDepth = 0;
        computeValues(root, 0);
        return ans;
    }

    private void computeValues(TreeNode currentNode, int currentLevel) {
        if (currentNode == null) return;
        // go down the next level
        computeValues(currentNode.left, currentLevel + 1);
        computeValues(currentNode.right, currentLevel + 1);
        // inspect the level to check whether it is the deepest level
        if (currentLevel == maxDepth) ans += currentNode.val;
        // at the first node at the deepest level
        if (currentLevel > maxDepth) {
            // update the maxDepth value
            maxDepth = currentLevel;
            // reset the accumulated value (ans) to the current node's value
            ans = currentNode.val;
        }
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

/**
 * references
 */