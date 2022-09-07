package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: September 06, 2022
 * 697. Degree of an Array
 * https://leetcode.com/problems/degree-of-an-array/
 */

public class P697 {
    // time & space: O(n)
    public int findShortestSubArray(int[] nums) {
        // determine array degree & the spread range of numbers
        // {num:[count,start,end]}
        int degree = 0;
        Map<Integer, int[]> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!hash.containsKey(num)) {
                hash.put(num, new int[]{1, i, i});
            } else {
                int[] stats = hash.get(num);
                stats[0]++; // update count
                stats[2] = i; // update end index
            }
            degree = Math.max(degree, hash.get(num)[0]);
        }
        // determine the solution (the length of subarray has the same array degree)
        int ans = Integer.MAX_VALUE;
        for (int val : hash.keySet()) {
            int[] stats = hash.get(val);
            if (stats[0] == degree) {
                ans = Math.min(ans, stats[2] - stats[1] + 1);
            }
        }
        return ans;
    }
}
