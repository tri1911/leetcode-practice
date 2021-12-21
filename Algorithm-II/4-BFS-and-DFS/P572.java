package algorithm2.bdfAndDfs;

// Date: Dec 16, 2021
// 572. Subtree of Another Tree
// https://leetcode.com/problems/subtree-of-another-tree/

// TODO: rethink the solution

// time complexity: O(n*m) where n is the number of nodes in root and m is the number of nodes in sub root
// space complexity: O(1)
public class P572 {
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    // takes O(m) where m is the number of node in tree2
    private static boolean isSame(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null || tree2 == null)
            return tree1 == null && tree2 == null;
        if (tree1.val == tree2.val) {
            return isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right);
        }
        return false;
    }

    public static class TreeNode {
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

// reference: https://www.youtube.com/watch?v=HdMs2Fl_I-Q