package leetcodingchallenge.august2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Date: August 13, 2022
 * 30. Substring with Concatenation of All Words
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

// TODO: check out the sliding-window approach in official solution

public class P30 {
    private HashMap<String, Integer> counter = new HashMap<>();
    private int wordLen;
    private int subLen;
    private int numWords;

    public List<Integer> findSubstring(String s, String[] words) {
        counter = new HashMap<>();
        for (String word : words) counter.put(word, counter.getOrDefault(word, 0) + 1);
        wordLen = words[0].length();
        subLen = words.length * wordLen;
        numWords = words.length;

        List<Integer> ans = new ArrayList<>();
        for (int candidate = 0; candidate <= s.length() - subLen; candidate++) {
            if (checkValid(candidate, s)) {
                ans.add(candidate);
            }
        }
        return ans;
    }

    private boolean checkValid(int candidate, String s) {
        HashMap<String, Integer> remaining = new HashMap<>(counter);
        int found = 0;
        for (int i = candidate; i < candidate + subLen; i += wordLen) {
            String word = s.substring(i, i + wordLen);
            if (remaining.containsKey(word) && remaining.get(word) > 0) {
                remaining.put(word, remaining.get(word) - 1);
                found++;
            } else {
                break;
            }
        }
        return found == numWords;
    }
}

/**
 * References
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/solution/
 */