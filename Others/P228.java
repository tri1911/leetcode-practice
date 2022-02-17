package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: Feb 16, 2022
 * 228. Summary Ranges
 * https://leetcode.com/problems/summary-ranges/
 */

public class P228 {
    // time: O(n)
    // space: O(1)
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return ans;
        int first = nums[0];
        String current = String.valueOf(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                ans.add(nums[i - 1] != first ? current + "->" + nums[i - 1] : current);
                first = nums[i];
                current = String.valueOf(nums[i]);
            }
        }
        ans.add(nums[n - 1] != first ? current + "->" + nums[n - 1] : current);
        return ans;
    }
}
