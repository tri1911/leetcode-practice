package leetcodingchallenge.july2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: July 29, 2022
 * 890. Find and Replace Pattern
 * https://leetcode.com/problems/find-and-replace-pattern/
 */

// TODO: check out the official solution

public class P890 {
    // time: O(n * k) where n is number of words, k is the length of pattern
    // space: O(1)
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int[] hash1, hash2;
        for (String word : words) {
            hash1 = new int[26];
            hash2 = new int[26];
            int i;
            for (i = 0; i < pattern.length(); i++) {
                int key1 = word.charAt(i) - 'a';
                int key2 = pattern.charAt(i) - 'a';
                if (hash1[key1] != 0 && hash1[key1] == key2 + 1 && hash2[key2] == key1 + 1) {
                    continue;
                } else if (hash1[key1] == 0 && hash2[key2] == 0) {
                    hash1[key1] = key2 + 1;
                    hash2[key2] = key1 + 1;
                } else {
                    break;
                }
            }
            if (i == pattern.length()) {
                ans.add(word);
            }
        }
        return ans;
    }
}
