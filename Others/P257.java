package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: Feb 17, 2022
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 */

// time: O(n)
// space: O(h)
public class P257 {
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        preorder(root, "");
        return ans;
    }

    private void preorder(TreeNode current, String tmp) {
        if (current == null) return;
        String str = tmp;
        if (str != "") str += "->";
        str += current.val;
        if (current.left == null && current.right == null) {
            ans.add(str);
            return;
        }
        preorder(current.left, str);
        preorder(current.right, str);
    }

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
