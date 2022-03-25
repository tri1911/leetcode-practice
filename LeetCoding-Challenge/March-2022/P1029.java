package leetcodingchallenge.march2022;

import java.util.*;

/**
 * Date: March 25, 2022
 * 1029. Two City Scheduling
 * https://leetcode.com/problems/two-city-scheduling/
 */

public class P1029 {
    // first attempt - not refactor yet
    // time: O(nlog(n))
    // space: O(n)
    public int _twoCitySchedCost(int[][] costs) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        int ans = 0, n = costs.length / 2;
        for (int[] cost : costs) {
            int dif = cost[0] - cost[1];
            if (dif <= 0) {
                listA.add(-dif);
                ans += cost[0];
            } else {
                listB.add(dif);
                ans += cost[1];
            }
        }
        if (listA.size() > n) {
            Collections.sort(listA);
            int k = listA.size() - n;
            for (int i = 0; i < k; i++) ans += listA.get(i);
        } else {
            Collections.sort(listB);
            int k = listB.size() - n;
            for (int i = 0; i < k; i++) ans += listB.get(i);
        }
        return ans;
    }

    // one-loop approach - the space complexity is better, however, the run time is worse than above approach in overall
    // time: O(nlog(n))
    // space: O(1)
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
        int n = costs.length / 2, ans = 0;
        for (int i = 0; i < n; i++) ans += costs[i][0] + costs[2 * n - 1 - i][1];
        return ans;
    }

    public static void main(String[] args) {
        P1029 obj = new P1029();
        int[][] costs = {{518, 518}, {71, 971}, {121, 862}, {967, 607}, {138, 754}, {513, 337}, {499, 873}, {337, 387}, {647, 917}, {76, 417}};
        System.out.println("Expected: 3671. Received: " + obj.twoCitySchedCost(costs));
    }
}

// TODO: check out the better approach
/*
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length; // number of people
        int[][] memo = new int[(n/2) + 1][(n/2) + 1]; // n/2 is capacity of each city
        return dfs(n - 1, n / 2, n / 2, costs, memo);
    }

    int dfs(int index, int num_a, int num_b, int[][] costs, int[][] memo) {
        // terminate
        if (index < 0) {
            return 0;
        }

        if (memo[num_a][num_b] > 0) return memo[num_a][num_b];

        int[] currCosts = costs[index];
        int ans = 0;

        // constraints
        if (num_a == 0) {
            ans = currCosts[1] + dfs(index - 1, num_a, num_b - 1, costs, memo);
        } else if (num_b == 0) {
            ans = currCosts[0] + dfs(index - 1, num_a - 1, num_b, costs, memo);
        } else {
            int min_b = currCosts[1] + dfs(index - 1, num_a, num_b - 1, costs, memo);
            int min_a = currCosts[0] + dfs(index - 1, num_a - 1, num_b, costs, memo);
            ans = Math.min(min_b, min_a);
        }

        memo[num_a][num_b] = ans;
        return memo[num_a][num_b];
    }
 */

/**
 * reference
 * https://leetcode.com/problems/two-city-scheduling/discuss/278716/C%2B%2B-O(n-log-n)-sort-by-savings
 */