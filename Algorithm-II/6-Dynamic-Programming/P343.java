package algorithm2.dynamicProgramming;

// date: Dec 24, 2021
// 343. Integer Break
// https://leetcode.com/problems/integer-break/

public class P343 {
    // time complexity: O(n * n)
    // space complexity: O(n)
    public int integerBreak(int n) {
        // dp[i] denotes the maximum product of integers that sums up to i
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int first = 1; first < i; first++) {
                // remain can be sum by 0 + remain as well
                int remain = i - first;
                dp[i] = Math.max(dp[i], first * Math.max(dp[remain], remain));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        P343 p = new P343();
        System.out.println("----------------------------");
        System.out.println("Input: n = 2");
        System.out.println("Expect: 1");
        System.out.println("Output: " + p.integerBreak(2));
        System.out.println("----------------------------");
        System.out.println("Input: n = 10");
        System.out.println("Expect: 36");
        System.out.println("Output: " + p.integerBreak(10));
    }
}
