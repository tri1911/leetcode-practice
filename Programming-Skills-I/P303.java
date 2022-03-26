package programmingSkills1;

/**
 * Date: March 25, 2022
 * 303. Range Sum Query - Immutable
 * https://leetcode.com/problems/range-sum-query-immutable/
 */

public class P303 {
    final private int[] ps;

    // time: O(n)
    public P303(int[] nums) {
        int n = nums.length;
        ps = new int[n + 1];
        for (int i = 1; i <= n; i++) ps[i] = ps[i - 1] + nums[i - 1];
    }

    // time: O(1)
    public int sumRange(int left, int right) {
        return ps[right + 1] - ps[left];
    }
}
