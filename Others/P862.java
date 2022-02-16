package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Feb 15, 2022
 * 862. Shortest Subarray with Sum at Least K
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 */

public class P862 {
    // time:
    // space:
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // key is the sum & value is the most recent index
        Map<Integer, Integer> presum = new HashMap<>();
        presum.put(0, -1);
        int ans = Integer.MAX_VALUE, currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            if (presum.containsKey(currentSum - k)) {
                ans = Math.min(ans, i - presum.get(currentSum - k));
            }
            presum.put(currentSum, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        P862 obj = new P862();
        System.out.println("Expected: 1. Received: " + obj.shortestSubarray(new int[]{1}, 1));
        System.out.println("Expected: 2. Received: " + obj.shortestSubarray(new int[]{48, 99, 37, 4, -31}, 140));
    }
}
