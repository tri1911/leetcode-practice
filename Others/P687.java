package others;

/**
 * Date: Feb 15, 2022
 * 687. Longest Univalue Path
 * https://leetcode.com/problems/longest-univalue-path/
 */

// TODO: review the question + solution (it is quite confusing question)

public class P687 {
    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }

    // use depth-first search
    // helper function to compute the length of the longest path which is rooted from the current node
    private int helper(TreeNode current) {
        if (current == null) return 0;
        int left = helper(current.left);
        int right = helper(current.right);
        int onLeft = 0, onRight = 0;
        if (current.left != null && current.left.val == current.val) onLeft = left + 1;
        if (current.right != null && current.right.val == current.val) onRight = right + 1;
        // update the global solution
        ans = Math.max(ans, onLeft + onRight);
        return Math.max(onLeft, onRight);
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

/**
 * reference
 * https://leetcode.com/problems/longest-univalue-path/solution
 */