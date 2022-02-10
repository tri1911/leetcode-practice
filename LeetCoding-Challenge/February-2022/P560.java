package leetcodingchallenge.february2022;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Feb 10, 2022
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */

// TODO: review all approaches in the official solution

public class P560 {
    // use prefix sum & hash map
    // time: O(n)
    // space: O(n)
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>(); // represents the accumulated sum until ith index
        counter.put(0, 1);
        int currentSum = 0, ans = 0;
        for (int num : nums) {
            currentSum += num;
            if (counter.containsKey(currentSum - k))
                ans += counter.get(currentSum - k);
            counter.put(currentSum, counter.getOrDefault(currentSum, 0) + 1);
        }
        return ans;
    }
}

/**
 * reference
 * https://leetcode.com/problems/subarray-sum-equals-k/solution/
 */