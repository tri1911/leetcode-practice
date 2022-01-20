package topInterviewQs;

/**
 * Date: Jan 20, 2022
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 */

public class P238 {
    // my own solution
    // time: O(n)
    // space: O(1)
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int total = 1, zeros = 0;
        // takes O(n)
        for (int val : nums) {
            if (val != 0) total *= val;
            else zeros++;
        }
        // takes O(n)
        for (int i = 0; i < nums.length; i++) {
            if (zeros > 1) {
                answer[i] = 0;
            } else if (zeros == 1) {
                if (nums[i] == 0) answer[i] = total;
                else answer[i] = 0;
            } else {
                answer[i] = total / nums[i];
            }
        }
        return answer;
    }

    /* Brilliant approach
    int n = nums.length;
    int[] answer = new int[n];
    for (int i = 0; i < n; i++)
        answer[i] = i == 0 ? 1 : answer[i - 1] * nums[i - 1];
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        answer[i] *= right;
        right *= nums[i];
    }
    return answer;
 */
}

/**
 * reference
 * https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
 */
