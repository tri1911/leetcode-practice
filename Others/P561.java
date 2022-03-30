package others;

import java.util.Arrays;

/**
 * Date: March 29, 2022
 * 561. Array Partition I
 * https://leetcode.com/problems/array-partition-i/
 */

public class P561 {
    // time: O(n*log(n))
    // space: O(1)
    public int _arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) if (i % 2 == 0) ans += nums[i];
        return ans;
    }

    // optimized approach - Counting sort
    // time: O(n)
    public int arrayPairSum(int[] nums) {
        int[] counter = new int[20_001];
        for (int num : nums) counter[num + 10_000]++;
        int ans = 0;
        for (int i = 0, current = 0; current < nums.length && i < 20_001; i++) {
            while (counter[i] > 0) {
                if (current % 2 == 0) ans += i - 10_000;
                counter[i]--;
                current++;
            }
        }
        return ans;
    }
}
