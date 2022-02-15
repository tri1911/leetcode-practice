package leetcodingchallenge.february2022;

/**
 * Date: Feb 15, 2022
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 */

public class P136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums)
            ans ^= num;
        return ans;
    }
}
