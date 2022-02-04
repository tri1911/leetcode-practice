package leetcodingchallenge.february2022;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Feb 04, 2022
 * 525. Contiguous Array
 * https://leetcode.com/problems/contiguous-array/
 */

// TODO: check out the approach 2 in official solution

public class P525 {
    // time: O(n)
    // space: O(n)
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int ans = 0, current = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, -1);
        for (int i = 0; i < n; i++) {
            current += nums[i] == 0 ? -1 : 1;
            if (hash.containsKey(current)) {
                ans = Math.max(ans, i - hash.get(current));
            } else {
                hash.put(current, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P525 obj = new P525();
        System.out.println("Expected: 2. Received: " + obj.findMaxLength(new int[]{0, 1}));
        System.out.println("Expected: 2. Received: " + obj.findMaxLength(new int[]{0, 1, 0}));
        System.out.println("Expected: 6. Received: " + obj.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }
}


/**
 * reference
 * https://leetcode.com/problems/contiguous-array/solution/
 */