package others;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Date: Jan 26, 2022
 * 1673. Find the Most Competitive Subsequence
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/
 */

// TODO: check out the solution if have time

public class P1673 {
    // my own solution
    // time: O(n)
    // space: O(1)
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && i < n - (k - j) && nums[i] < ans[j - 1]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }

    /*  first attempt using stack - time: O(n) & space: O(n)
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && i < n - k && nums[i] < stack.peek()) {
                stack.pop();
                k++;
            }
            if (k > 0) {
                stack.push(nums[i]);
                k--;
            }
        }
        int[] ans = new int[stack.size()];
        int i = stack.size() - 1;
        for (int val : stack)
            ans[i--] = val;
        return ans;
     */

    public static void main(String[] args) {
        P1673 obj = new P1673();
        System.out.println("Expected: [2, 6]. Received: " + Arrays.toString(obj.mostCompetitive(new int[]{3, 5, 2, 6}, 2)));
        System.out.println("Expected: [2, 3, 3, 4]. Received: " + Arrays.toString(obj.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4)));
        System.out.println("Expected: [8, 80, 2]. Received: " + Arrays.toString(obj.mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3)));
    }
}

/**
 * reference
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/discuss/952786/JavaC%2B%2BPython-One-Pass-Stack-Solution
 */
