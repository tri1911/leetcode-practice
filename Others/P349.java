package others;

import java.util.Arrays;

/**
 * Date: Feb 21, 2022
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */

public class P349 {
    // time: O(m + n)
    // space: O(1)
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] hash = new boolean[1001];
        for (int num : nums1) hash[num] = true;
        int i = 0;
        int[] ans = new int[nums2.length];
        for (int num : nums2) {
            if (hash[num]) {
                ans[i++] = num;
                hash[num] = false;
            }
        }
        return Arrays.copyOf(ans, i);
    }
}
