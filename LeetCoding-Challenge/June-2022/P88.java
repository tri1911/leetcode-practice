package leetcodingchallenge.june2022;

/**
 * Date: June 07, 2022
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 */

public class P88 {
    // time: O(m + n)
    // space: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p2 < 0) nums1[i] = nums1[p1--];
            else if (p1 < 0) nums1[i] = nums2[p2--];
            else nums1[i] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
    }
}
