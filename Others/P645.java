package others;

/**
 * Date: September 06, 2022
 * 645. Set Mismatch
 * https://leetcode.com/problems/set-mismatch/
 */

// TODO: implement the solution with constant space

public class P645 {
    // time & space: O(n)
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        // count numbers' frequencies
        int[] hash = new int[n + 1];
        for (int num : nums) hash[num]++;
        // determine the solution
        int[] ans = new int[2];
        for (int num = 1; num <= n; num++) {
            if (hash[num] == 2) ans[0] = num;
            else if (hash[num] == 0) ans[1] = num;
        }
        return ans;
    }
}
