package algorithm2.backtracking;

// date: Dec 17, 2021
// 90. Subsets II
// https://leetcode.com/problems/subsets-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Analyze time complexity and check out another better/precise solution

// time complexity: _
// space complexity: O(n)
public class P90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            dfs(0, k, nums, comb, ans);
        }
        return ans;
    }

    private void dfs(int start, int k, int[] nums, List<Integer> comb, List<List<Integer>> ans) {
        if (k == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= nums.length - k; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            comb.add(nums[i]);
            dfs(i + 1, k - 1, nums, comb, ans);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        P90 p = new P90();
        System.out.println("Expected: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]");
        System.out.println("Output: " + p.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println("----------------------------------------------------");
        System.out.println("Expected: [[], [0]]");
        System.out.println("Output: " + p.subsetsWithDup(new int[]{0}));
        System.out.println("----------------------------------------------------");
        System.out.println("Expected: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]");
        System.out.println("Output: " + p.subsetsWithDup(new int[]{1, 2, 3}));
        System.out.println("----------------------------------------------------");
        System.out.println("Expected: [[], [1], [1, 4], [1, 4, 4], [1, 4, 4, 4], [1, 4, 4, 4, 4], [4], [4, 4], [4, 4, 4], [4, 4, 4, 4]]");
        System.out.println("Output: " + p.subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }
}
