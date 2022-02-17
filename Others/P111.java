package others;

/**
 * Date: Feb 17, 2022
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */

// time: O(n)
// space: O(h)
public class P111 {
    int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        getDepth(root, 1);
        return ans;
    }

    private void getDepth(TreeNode current, int val) {
        if (current == null) return;
        if (current.left == null && current.right == null) {
            ans = Math.min(ans, val);
            return;
        }
        getDepth(current.left, val + 1);
        getDepth(current.right, val + 1);
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
