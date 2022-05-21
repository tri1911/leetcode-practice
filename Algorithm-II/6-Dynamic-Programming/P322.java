package algorithm2.dynamicProgramming;

/**
 * Date: Dec 24, 2021 - Redo: May 21, 2022 (Daily challenge)
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 */

import java.util.Arrays;

public class P322 {
    // dynamic programming approach
    // cannot use greedy approach -> [1, 3, 4] amount = 6 then {4, 1, 1} > {3, 3}
    // time: O(amount*n) where n is the length of coins array
    // space: O(amount)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int val : coins) {
                int remain = i - val;
                if (remain >= 0 && dp[remain] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[remain]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        P322 p = new P322();
        System.out.println("----------------------------");
        System.out.println("Input: coins = [1, 2, 5], amount = 11");
        System.out.println("Expect: 3");
        System.out.println("Output: " + p.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println("----------------------------");
        System.out.println("Input: coins = [2], amount = 3");
        System.out.println("Expect: -1");
        System.out.println("Output: " + p.coinChange(new int[]{2}, 3));
        System.out.println("----------------------------");
        System.out.println("Input: coins = [1], amount = 0");
        System.out.println("Expect: 0");
        System.out.println("Output: " + p.coinChange(new int[]{1}, 0));
    }
}
