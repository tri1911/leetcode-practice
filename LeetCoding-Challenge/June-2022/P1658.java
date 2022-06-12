package leetcodingchallenge.june2022;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: June 11, 2022
 * 1658. Minimum Operations to Reduce X to Zero
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 */

public class P1658 {
    // problem can be rephrased as "find the sub-array with sum of (total - x)"

    // 1 - Hash Table & Prefix Sum approach
    // time: O(n)
    // space: O(n)
    public int _minOperations(int[] nums, int x) {
        int n = nums.length, target = -x;
        for (int num : nums) target += num;
        if (target == 0) return n;
        // {acc:i} - accumulated sum from ith
        Map<Integer, Integer> ps = new HashMap<>();
        int maxLen = 0, sum = 0, dif;
        ps.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dif =  sum - target;
            if (ps.containsKey(dif)) {
                maxLen = Math.max(maxLen, i - ps.get(dif));
            }
            ps.put(sum, i);
        }
        return maxLen == 0 ? -1 : n - maxLen;
    }

    // TODO: redo for gain more understanding
    // 2 - Two pointers + Sliding Window approach -> Optimized solution (faster than above approach)
    // time: O(n)
    // space: O(1)
    public int minOperations(int[] nums, int x) {
        // compute (total - x)
        int n = nums.length, target = -x;
        for (int num : nums) target += num;
        // base cases
        if (target == 0) return n;
        else if (target < 0) return -1;
        // find the longest sub-array with sum of `target`
        int sum = 0, maxLen = 0;
        for (int right = 0, left = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target) sum -= nums[left++];
            if (sum == target) maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen == 0 ? -1 : n - maxLen;
    }
}

/**
 * references
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/935935/Java-Detailed-Explanation-O(N)-Prefix-SumMap-Longest-Target-Sub-Array
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */