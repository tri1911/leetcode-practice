package others;

// Date: Jan 8, 2022
// 41. First Missing Positive
// https://leetcode.com/problems/first-missing-positive/

import java.util.*;

public class P41 {
    /*  My own solution using hash table but its space complexity does not meet the requirement
        // time complexity: O(n)
        // space complexity: O(n)
        public int firstMissingPositive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (num > 0)
                    set.add(num);
            }
            int ans = 1;
            while (set.contains(ans))
                ans++;
            return ans;
        }
     */

    /* Observation
     1 should be located at index 0
     2 should be located at index 1
     ...
     in general, k should be located at index k - 1
     in other words, nums[k - 1] == k
     so when examine nums[i], we swap it until nums[i] == nums[nums[i] - 1]
     */

    // optimized solution
    // time complexity: O(n)
    // space complexity: O(1)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // although there is a nested while loop
        // this loop overall takes at most O(n)
        // since each element will be swapped into its correct position at most once
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
        }
        int ans = 1;
        while (ans <= n && nums[ans - 1] == ans)
            ans++;
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        P41 obj = new P41();
        System.out.println("Expected: 2. Received: " + obj.firstMissingPositive(new int[]{1}));
        System.out.println("Expected: 3. Received: " + obj.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println("Expected: 2. Received: " + obj.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println("Expected: 1. Received: " + obj.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}

// reference
// https://leetcode.com/problems/first-missing-positive/discuss/17071/My-short-c%2B%2B-solution-O(1)-space-and-O(n)-time