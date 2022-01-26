package leetcodingchallenge.january2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: Jan 26, 2022
 * 1305. All Elements in Two Binary Search Trees
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */

// TODO: check out the optimized solution...

public class P1305 {
    // my own solution
    // time: O(m + n)
    // space: O(m + n)
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        // populate 2 lists using inorder traversal - O(m + n) time
        inorder(root1, list1);
        inorder(root2, list2);
        // edge case
        if (root1 == null || root2 == null) return root1 == null ? list2 : list1;
        // merge 2 lists - O(m + n) time
        List<Integer> ans = new ArrayList<>();
        int n1 = list1.size();
        int n2 = list2.size();
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) ans.add(list1.get(i) < list2.get(j) ? list1.get(i++) : list2.get(j++));
        while (i < n1) ans.add(list1.get(i++));
        while (j < n2) ans.add(list2.get(j++));
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
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
