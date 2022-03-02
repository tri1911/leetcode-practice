package others;

/**
 * Date: March 02, 2022
 * 2185. Counting Words With a Given Prefix
 * https://leetcode.com/problems/counting-words-with-a-given-prefix/
 */

public class P2185 {
    // time: O(m*n)
    // space: O(1)
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) ans += word.indexOf(pref) == 0 ? 1 : 0;
        return ans;
    }
}
