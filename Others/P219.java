package others;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Feb 16, 2022
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/
 */

public class P219 {
    // time: O(n)
    // space: O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i]) && i - hash.get(nums[i]) <= k) {
                return true;
            }
            hash.put(nums[i], i);
        }
        return false;
    }
}
