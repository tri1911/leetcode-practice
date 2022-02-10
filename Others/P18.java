package others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Date: Feb 10, 2022
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/
 */

// TODO: read the official solution

public class P18 {
    // time: O(n^3)
    // space: O(1)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        if (n < 4) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < n - 2; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int val = target - nums[i] - nums[j];
                        int low = j + 1, high = n - 1;
                        while (low < high) {
                            if (nums[low] + nums[high] == val) {
                                ans.add(Arrays.asList(nums[i], nums[j], nums[low++], nums[high--]));
                                while (low < high && nums[low] == nums[low - 1]) low++;
                                while (low < high && nums[high] == nums[high + 1]) high--;
                            } else if (nums[low] + nums[high] > val) {
                                high--;
                            } else {
                                low++;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}

/**
 * reference
 * https://leetcode.com/problems/4sum/solution/
 */