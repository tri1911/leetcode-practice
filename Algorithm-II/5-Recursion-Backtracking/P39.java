package algorithm2.backtracking;

// date: Dec 20, 2021
// 39. Combination Sum
// https://leetcode.com/problems/combination-sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backtracking(0, target, candidates, comb, ans);
        return ans;
    }

    private void backtracking(int start, int target, int[] candidates, List<Integer> comb, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList(comb));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];
            if (val <= target) {
                comb.add(val);
                backtracking(i, target - val, candidates, comb, ans);
                comb.remove(comb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        P39 p = new P39();
        System.out.println("Expect: [[2, 2, 3], [7]]\nOutput: " + p.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println("Expect: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]\nOutput: " + p.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println("Expect: []\nOutput: " + p.combinationSum(new int[]{2}, 1));
    }
}
