package topInterviewQs;

/**
 * Date: Jan 8, 2022 - redo on July 05, 2022
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */

import java.util.*;

public class P128 {
    /*  First attempt
        // time complexity: O(n*log(n))
        // space complexity: O(1)
        public int longestConsecutive(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            // takes O(n*log(n))
            Arrays.sort(nums);
            int ans = 1;
            int current = 1;
            // takes O(n)
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1] + 1)
                    ans = Math.max(ans, ++current);
                else if (nums[i] == nums[i - 1])
                    continue;
                else
                    current = 1;
            }
            return ans;
        }
     */

    // linear algorithm - use hash table
    // time complexity: O(n)
    // space complexity: O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // populates the number set - O(n)
        for (int num : nums)
            set.add(num);
        // find the solution - O(n)
        int ans = 0;
        for (int val : set) {
            // we count forward only -> the loop for a consecutive sequence runs only once
            if (!set.contains(val - 1)) {
                int count = 1;
                // each look up operation takes O(1)
                while (set.contains(val + 1)) {
                    count++;
                    val++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P128 obj = new P128();
        System.out.println("Expected: 4. Received: " + obj.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println("Expected: 9. Received: " + obj.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println("Expected: 1. Received: " + obj.longestConsecutive(new int[]{0}));
        System.out.println("Expected: 0. Received: " + obj.longestConsecutive(new int[]{}));
        System.out.println("Expected: 3. Received: " + obj.longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}

/**
 * reference
 * https://leetcode.com/problems/longest-consecutive-sequence/solution/
 */