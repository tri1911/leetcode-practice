package leetcodingchallenge.february2022;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Feb 9, 2022
 * 532. K-diff Pairs in an Array
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */

public class P532 {
    // first attempt - my own solution with 2 passes
    // time: O(n)
    // space: O(n)

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int ans = 0;
        for (int num : nums)
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if ((k == 0 && val > 1) || (k != 0 && counter.containsKey(key + k) && counter.get(key + k) > 0)) ans++;
        }
        return ans;
    }

    // optimized to 1 pass
    public int _findPairs(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if (k == 0) {
                if (counter.containsKey(num) && counter.get(num) == 1) ans++;
            } else {
                if (counter.containsKey(num)) continue;
                if (counter.containsKey(num - k)) ans++;
                if (counter.containsKey(num + k)) ans++;
            }
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
}

/**
 * reference
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/discuss/100098/Java-O(n)-solution-one-Hashmap-easy-to-understand
 */
