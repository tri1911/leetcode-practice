package algorithm2.slidingWindow;

// date: Dec 15, 2021
// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/

// time complexity: O(n)
// space complexity: O(1)
public class P209 {
    // find the minimal length of a contiguous subarray of which the sum is >= target
    // if there is no such subarray, return 0
    public static int minSubArrayLen(int target, int[] nums) {
        int begin = 0, sum = 0, ans = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - begin + 1);
                sum -= nums[begin++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // TODO: try coding another solution of which the time complexity is O(nlog(n))

    public static void main(String[] args) {
        System.out.println("Expect: 2. Received: " + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println("Expect: 1. Received: " + minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println("Expect: 0. Received: " + minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
