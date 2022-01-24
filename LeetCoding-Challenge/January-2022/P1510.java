package leetcodingchallenge.january2022;

import java.util.HashMap;

/**
 * Date: Jan 23, 2022
 * 1510. Stone Game IV
 * https://leetcode.com/problems/stone-game-iv/
 */

// TODO: review official solution, implement DP approach and analyze time complexity

public class P1510 {
    // memoization approach
    // time: O(n * sqrt(n))
    // space: O(n)
    public boolean winnerSquareGame(int n) {
        HashMap<Integer, Boolean> memo = new HashMap<>();
        memo.put(0, false);
        return dfs(n, memo);
    }

    private boolean dfs(int remain, HashMap<Integer, Boolean> memo) {
        if (memo.containsKey(remain)) return memo.get(remain);
        for (int k = 1; k * k <= remain; k++) {
            if (!dfs(remain - k * k, memo)) {
                memo.put(remain, true);
                return true;
            }
        }
        memo.put(remain, false);
        return false;
    }
}

/**
 * reference
 * https://leetcode.com/problems/stone-game-iv/solution/
 */