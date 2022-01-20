package topInterviewQs;

// Date: Jan 3, 2022
// 454. 4Sum II
// https://leetcode.com/problems/4sum-ii/

import java.util.HashMap;
import java.util.Map;

public class P454 {
    /* my own solution in first attempt
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length, sum1, sum2;
        int ans = 0;
        // combine nums1 and nums2 to an sum array with size of n * n
        Map<Integer, Integer> counter1 = new HashMap<>();
        Map<Integer, Integer> counter2 = new HashMap<>();
        // take O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum1 = nums1[i] + nums2[j];
                counter1.put(sum1, counter1.getOrDefault(sum1, 0) + 1);
                sum2 = nums3[i] + nums4[j];
                counter2.put(sum2, counter2.getOrDefault(sum2, 0) + 1);
            }
        }
        // find solution - take O(n^2)
        for (Map.Entry<Integer, Integer> entry : counter1.entrySet()) {
            int key = -entry.getKey();
            int value = entry.getValue();
            if (counter2.containsKey(key)) {
                ans += value * counter2.get(key);
            }
        }
        return ans;
    }
     */

    // optimized implementation - only need 1 map
    // time complexity: O(n^2)
    // space complexity: O(n^2)
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length, sum, ans = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = nums1[i] + nums2[j];
                counter.put(sum, counter.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = nums3[i] + nums4[j];
                if (counter.containsKey(-sum))
                    ans += counter.get(-sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P454 obj = new P454();
        System.out.println("Expect: 2. Output: " + obj.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        System.out.println("Expect: 1. Output: " + obj.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
    }
}

/*
    Example 1:
    Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
    Output: 2
    Explanation:
    The two tuples are:
    1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0

    Example 2:
    Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
    Output: 1

    Constraints:
    n == nums1.length
    n == nums2.length
    n == nums3.length
    n == nums4.length
    1 <= n <= 200
    -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
 */

// reference
// https://leetcode.com/problems/4sum-ii/discuss/93920/Clean-java-solution-O(n2)