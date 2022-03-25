package programmingSkills1;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: March 24, 2022
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 */

public class P217 {
    // time: O(n)
    // space: O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
