package others;

/**
 * Date: Feb 27, 2022
 * 1684. Count the Number of Consistent Strings
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/
 */

public class P1684 {
    // time: O(s*t)
    // space: O(1)
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = words.length;
        boolean[] hash = new boolean[26];
        for (int i = 0; i < allowed.length(); i++)
            hash[allowed.charAt(i) - 'a'] = true;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!hash[word.charAt(i) - 'a']) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
