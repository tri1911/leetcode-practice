package algorithm2.backtracking;

/**
 * Date: Dec 20, 2021 - Redo: May 12, 2022
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 */

import java.util.*;

// TODO: analyze the time and space complexity

public class P47 {
    // redo on May 12, 2022

    private List<List<Integer>> ans;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        backtracking(nums, 0);
        return ans;
    }

    private void backtracking(int[] nums, int current) {
        int n = nums.length;
        if (current == n - 1) {
            List<Integer> arr = new ArrayList<>();
            for (int num : nums) arr.add(num);
            ans.add(arr);
        } else {
            boolean[] seen = new boolean[21];
            for (int i = current; i < n; i++) {
                if (i != current && seen[nums[i] + 10]) continue;
                seen[nums[i] + 10] = true;
                swap(nums, current, i);
                backtracking(nums, current + 1);
                swap(nums, current, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    /*  solution with sort
        // time: O(n!)
        // space: O(n)
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            Collections.sort(perm);
            List<List<Integer>> ans = new ArrayList<>();
            backtracking(0, perm, ans);
            return ans;
        }

        private void backtracking(int current, List<Integer> perm, List<List<Integer>> ans) {
            int n = perm.size();
            if (current == n) {
                ans.add(new ArrayList<>(perm));
                return;
            }
            for (int i = current; i < n; i++) {
                if (i > current && perm.get(i) == perm.get(i - 1)) continue;
                Collections.swap(perm, current, i);
                backtracking(current + 1, perm, ans);
                Collections.swap(perm, i, current);
            }
        }
    */

    /*  solution with Hash Map (use as a counter) - done on Dec 20, 2021
        // time complexity: O(n!)
        // space complexity: O(n)
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> curPerm = new ArrayList<>();
            Map<Integer, Integer> counter = new HashMap<>();
            for (int value : nums) {
                counter.put(value, counter.getOrDefault(value, 0) + 1);
            }
            backtracking(0, nums.length, counter, curPerm, ans);
            return ans;
        }

        private void backtracking(int current, int n, Map<Integer, Integer> counter, List<Integer> curPerm, List<List<Integer>> ans) {
            if (current == n) {
                ans.add(new ArrayList<>(curPerm));
                return;
            }
            for (int key : counter.keySet()) {
                int count = counter.get(key);
                if (count != 0) {
                    curPerm.add(key);
                    counter.replace(key, count - 1);
                    backtracking(current + 1, n, counter, curPerm, ans);
                    curPerm.remove(curPerm.size() - 1);
                    counter.replace(key, count);
                }
            }
        }
     */

    public static void main(String[] args) {
        P47 obj = new P47();
        System.out.println("---------------------");
        System.out.println("Input: nums = [1, 1, 2]");
        System.out.println("Expect: [[1, 1, 2], [1, 2, 1], [2, 1, 1]]");
        System.out.println("Output: " + obj.permuteUnique(new int[]{1, 1, 2}));
    }
}

/**
 * references
 * https://leetcode.com/problems/permutations-ii/solution/
 */