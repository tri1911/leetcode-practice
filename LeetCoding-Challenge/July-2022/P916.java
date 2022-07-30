package leetcodingchallenge.july2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: July 30, 2022
 * 916. Word Subsets
 * https://leetcode.com/problems/word-subsets/
 */

public class P916 {
    // time: O(m + n) where m, n is the total characters of words in words1, words2 respectively
    // space: O(1)
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // compute the max frequencies of letters among all words in `words2` array
        int[] maxWords2Counter = new int[26];
        for (String word : words2) {
            int[] currentCounter = new int[26];
            for (char ch : word.toCharArray()) {
                int key = ch - 'a';
                maxWords2Counter[key] = Math.max(maxWords2Counter[key], ++currentCounter[key]);
            }
        }
        List<String> ans = new ArrayList<>();
        // populate the answer list
        for (String word : words1) {
            int[] currentCounter = new int[26];
            for (char ch : word.toCharArray()) {
                currentCounter[ch - 'a']++;
            }
            int i;
            for (i = 0; i < 26; i++) {
                if (currentCounter[i] < maxWords2Counter[i]) {
                    break;
                }
            }
            if (i == 26) {
                ans.add(word);
            }
        }
        return ans;
    }
}
