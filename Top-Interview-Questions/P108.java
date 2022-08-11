package topInterviewQs;

/**
 * Date: Jan 10, 2022 - Redo: August 10, 2022 (Leetcode Daily Challenge)
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class P108 {
    // time complexity: O(n)
    // space complexity: O(1)
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int first, int last) {
        if (first > last) return null;
        int mid = (first + last) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = buildBST(nums, first, mid - 1);
        head.right = buildBST(nums, mid + 1, last);
        return head;
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
