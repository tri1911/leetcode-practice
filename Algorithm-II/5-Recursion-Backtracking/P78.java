package algorithm2.backtracking;

// date: Dec 17, 2021
// 78. Subsets
// https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;

// TODO: Analyze the time complexity & Check out leetcode solutions
// https://leetcode.com/problems/subsets/solution/

// TODO: read and try to understand this solution as well
// public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        result.add(new ArrayList<>());
//        if(nums == null || nums.length == 0){
//            return result;
//        }
//        int s = 0;
//        for(int n:nums){
//            s = result.size();
//            for(int i = 0;i<s;i++){
//                List<Integer> set = new ArrayList<>(result.get(i));
//                set.add(n);
//                result.add(set);
//            }
//        }
//        return result;
//    }

// time complexity: _
// space complexity: O(n)
public class P78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        // find possible combinations with the size of k, where k = [0, n]
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
            comb.add(nums[i]);
            dfs(i + 1, k - 1, nums, comb, ans);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        P78 p = new P78();
        System.out.println("Expected: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]\nOutput: " + p.subsets(new int[]{1, 2, 3}));
        System.out.println("Expected: [[], [0]]\nOutput: " + p.subsets(new int[]{0}));
    }
}
