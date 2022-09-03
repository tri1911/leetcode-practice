package leetcodingchallenge.september2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: September 03, 2022
 * 967. Numbers With Same Consecutive Differences
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */

public class P967 {
    // own solution
    // time & space: O(2^n)
    private List<Integer> ans;
    // for each value, there are 2 choices for its neighbor: val + k or val - k
    public int[] numsSameConsecDiff(int n, int k) {
        this.ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) dfs(n, k, 1, i);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int n, int k, int pos, int cur) {
        if (pos < n) {
            int lastDigit = cur % 10;
            if (lastDigit + k <= 9) dfs(n, k, pos + 1, cur * 10 + lastDigit + k);
            if (k != 0 && lastDigit - k >= 0) dfs(n, k, pos + 1, cur * 10 + lastDigit - k);
        } else {
            this.ans.add(cur);
        }
    }
}
