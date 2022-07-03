package leetcodingchallenge.july2022;

/**
 * Date: Sun, July 03, 2022 - just redo (already solved this problem in Sept 2021)
 * 376. Wiggle Subsequence
 * https://leetcode.com/problems/wiggle-subsequence/
 */

// TODO: checkout the official solution when have time

public class P376 {
    // time: O(n)
    // space: O(1)
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int i = 1, prevDif = nums[i] - nums[i - 1];
        while (i < n && prevDif == 0) prevDif = nums[i] - nums[i++ - 1];
        int ans = i < n ? 2 : 1;
        for (; i < n; i++) {
            int curDif = nums[i] - nums[i - 1];
            if (curDif * prevDif < 0) {
                ans++;
                prevDif = curDif;
            }
        }
        return ans;
    }
}
