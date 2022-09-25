package leetcodingchallenge.september2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: September 24, 2022
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 */

public class P113 {
    private List<List<Integer>> ans;
    private List<Integer> tmp;

    // DFS search approach
    // time: O(n)
    // space: O(n)
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        tmp = new ArrayList<>();
        ans = new ArrayList();
        dfs(root, 0, targetSum);
        return ans;
    }

    // helper function
    private void dfs(TreeNode node, int sum, int target) {
        if (node == null) return;

        tmp.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null && sum == target) ans.add(new ArrayList(tmp));

        dfs(node.left, sum, target);
        dfs(node.right, sum, target);

        tmp.remove(tmp.size() - 1);
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
