package leetcodingchallenge.may2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: May 04, 2022
 * 1679. Max Number of K-Sum Pairs
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */

public class P1679 {
    // Hash Table approach
    // time: O(n)
    // space: O(n)
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        // hash table contains the unique elements' frequencies
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) counter.put(num, counter.getOrDefault(num, 0) + 1);
        // count the max number of operations
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (k % 2 == 0 && key == k / 2) {
                ans += (value / 2);
            } else if (counter.containsKey(k - key)) {
                ans += Math.min(counter.get(k - key), value);
                counter.put(k - key, 0);
            }
        }
        return ans;
    }

    // Two Pointers approach
    // time: O(nlog(n))
    // space: O(1)
    public int _maxOperations(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                ans++; left++; right--;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }
}
