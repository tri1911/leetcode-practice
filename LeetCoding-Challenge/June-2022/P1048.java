package leetcodingchallenge.june2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: June 15, 2022
 * 1048. Longest String Chain
 * https://leetcode.com/problems/longest-string-chain/
 */

public class P1048 {
    // time: O(n*s*s) where n is the length `words` array & s is the length of each word
    // space: O(n*s)
    public int longestStrChain(String[] words) {
        int ans = 0;
        Map<String, Integer> dp = new HashMap<>();
        // takes O(log(n)) - sort the `words` array by its `length` in ascending order
        Arrays.sort(words, Comparator.comparingInt(String::length));
        // takes O(n*s*s)
        for (String word : words) {
            int best = 0;
            // compute the longest possible word chain end at current `word` from its `predecessor`
            for (int i = 0; i < word.length(); i++) {
                // predecessor is gotten by deleting one character at any position
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(predecessor, 0) + 1);
            }
            dp.put(word, best);
            ans = Math.max(ans, best);
        }
        return ans;
    }
}

/**
 * References
 * https://leetcode.com/problems/longest-string-chain/discuss/294890/JavaC%2B%2BPython-DP-Solution
 * https://www.baeldung.com/java-sorting-arrays
 * https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
 * https://www.baeldung.com/java-substring
 * https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 */