package leetcodingchallenge.june2022;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: June 10, 2022 (just redo, already solve it before in C++)
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class P3 {
    // time: O(n)
    // space: O(n)
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        int n = s.length(), ans = 0, first = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (hash.containsKey(ch) && hash.get(ch) >= first) {
                first = hash.get(ch) + 1;
            } else {
                ans = Math.max(ans, i - first + 1);
            }
            hash.put(s.charAt(i), i);
        }
        return ans;
    }
}
