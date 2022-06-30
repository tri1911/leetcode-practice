package leetcodingchallenge.june2022;

import java.util.Arrays;

/**
 * Date: June 30, 2022
 * 462. Minimum Moves to Equal Array Elements II
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 */

// TODO: use quick select to determine the median element (to achieve O(n) average time complexity)

public class P462 {
    // observations:
    // 1. e.g. for 1 < b < 10: for any b, (10 - b) + (b - 1) = 10 - 1 -> don't care about `b`
    // 2. increase or decrease elements into a certain value (let's call `target`)
    // - for arbitrary i (which is from 0 to len / 2): nums[i] <= target <= nums[len - 1 - i]
    // therefore the total steps takes (target - nums[i]) + ... + (nums[len - 1 - i] - target)
    // we can get rid `target`s, then gain: (nums[len - 1 - i] - nums[i]) + ...

    // time: O(n*log(n))
    // space: O(1)
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--)
            ans += nums[j] - nums[i];
        return ans;
    }
}


/**
 * references
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/94937/Java(just-like-meeting-point-problem)
 */