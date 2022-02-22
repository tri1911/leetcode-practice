package others;

/**
 * Date: Feb 22, 2022
 * 671. Second Minimum Node In a Binary Tree
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */

public class P671 {
    // time: O(n)
    // space: O(n)
    long ans = Long.MAX_VALUE;
    int firstMin;

    private void dfs(TreeNode current) {
        if (current == null) return;
        if (current.val > firstMin && current.val < ans) {
            ans = current.val;
        } else if (current.val == firstMin) {
            dfs(current.left);
            dfs(current.right);
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        firstMin = root.val;
        dfs(root);
        return ans != Long.MAX_VALUE ? (int) ans : -1;
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
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/solution/
 */