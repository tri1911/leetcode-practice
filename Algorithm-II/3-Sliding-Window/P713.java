package algorithm2.slidingWindow;

// date: Dec 15, 2021
// 713. Subarray Product Less Than K
// https://leetcode.com/problems/subarray-product-less-than-k/

// time complexity: O(n)
// space complexity: O(1)
public class P713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // edge case
        // if (k == 0) return 0; -> WRONG!!!!
        if (k <= 1) return 0;
        int begin = 0, product = 1, ans = 0;
        for (int end = 0; end < nums.length; end++) {
            product *= nums[end];
            while (product >= k) product /= nums[begin++];
            ans += end - begin + 1;
        }
        return ans;
    }

    // TODO: try to understand the solution using Binary Search

    public static void main(String[] args) {
        System.out.println("Expect: 8. Received: " + numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println("Expect: 0. Received: " + numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
        System.out.println("Expect: 0. Received: " + numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));
    }
}

// reference
// https://leetcode.com/problems/subarray-product-less-than-k/solution/