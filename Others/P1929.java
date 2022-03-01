package others;

/**
 * Date: Feb 27, 2022
 * 1929. Concatenation of Array
 * https://leetcode.com/problems/concatenation-of-array/
 */

public class P1929 {
    // time: O(n)
    // space: O(1)
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) ans[i] = ans[i + n] = nums[i];
        return ans;
    }
}
