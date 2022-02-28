package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: Feb 16, 2022 - Redo as LC Daily Challenge (Feb 28, 2022)
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
        for (int i = 1; i <= n; i++) {
            if (i == n || nums[i - 1] + 1 != nums[i]) {
                ans.add(first + (nums[i - 1] != first ? "->" + nums[i - 1] : ""));
                if (i < n) first = nums[i];
            }
        }
        return ans;
    }
}
