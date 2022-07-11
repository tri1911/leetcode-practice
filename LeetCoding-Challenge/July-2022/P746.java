package leetcodingchallenge.july2022;

/**
 * Date: July 10, 2022 (already solved in Sept 11, 2021)
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */

public class P746 {
    // time: O(n)
    // space: O(1)
    public int minCostClimbingStairs(int[] cost) {
        int first = cost[0], second = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int best = Math.min(first, second) + cost[i];
            first = second;
            second = best;
        }
        return Math.min(first, second);
    }
}
