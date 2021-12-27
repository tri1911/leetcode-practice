package algorithm2.backtracking;

// date: Dec 20, 2021
// 40. Combination Sum II
// https://leetcode.com/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: analyze time complexity and redo with counter approach

public class P40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backtracking(0, target, candidates, comb, ans);
        return ans;
    }

    private void backtracking(int start, int target, int[] candidates, List<Integer> comb, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            int val = candidates[i];
            if (val <= target) {
                comb.add(val);
                backtracking(i + 1, target - val, candidates, comb, ans);
                comb.remove(comb.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        P40 p = new P40();
        System.out.println("Input: candidates = [10, 1, 2, 7, 6, 1, 5], target = 8");
        System.out.println("Expect: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]] \nOutput: " + p.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println("-------------------------------------------------");
        System.out.println("Input: candidates = [2, 5, 2, 1, 2], target = 5");
        System.out.println("Expect: [[1, 2, 2], [5]] \nOutput: " + p.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
