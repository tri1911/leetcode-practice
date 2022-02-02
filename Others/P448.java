package others;

import java.util.*;

/**
 * Date: Feb 1, 2022
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */

public class P448 {
    // first attempt using Hash Table
    // time: O(n)
    // space: O(n)
    public List<Integer> _findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        List<Integer> ans = new LinkedList<>();
        for (int i = 1; i <= n; i++) if (!set.contains(i)) ans.add(i);
        return ans;
    }

    // optimize with constant space - similar approach to the "first missing positive" problem
    // time: O(n) since each number is filled into its correct spot at most once
    // space: O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        // sort array
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                // swap to put the nums[i] into its correct place (at the index nums[i] - 1)
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        // find missing integers from the sorted array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P448 obj = new P448();
        System.out.println("Expected: [5, 6]. Received: " + obj.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}

/**
 * reference
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/93007/Simple-Java-In-place-sort-solution
 * https://leetcode.com/problems/first-missing-positive/
 */