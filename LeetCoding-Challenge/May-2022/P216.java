package leetcodingchallenge.may2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: May 09, 2022
 * 216. Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/
 */

public class P216 {
    private List<List<Integer>> ans;
    private List<Integer> tmp;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        tmp = new ArrayList<>();
        backtracking(k, n, 1);
        return ans;
    }

    private void backtracking(int k, int n, int from) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = from; i <= 9; i++) {
            if (i > n) break;
            tmp.add(i);
            backtracking(k - 1, n - i, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
