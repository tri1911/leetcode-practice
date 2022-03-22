package programmingSkills1;

/**
 * Date: March 21, 2022
 * 1768. Merge Strings Alternately
 * https://leetcode.com/problems/merge-strings-alternately/
 */

public class P1768 {
    // time: O(n)
    // space: O(1)
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length(), n = Math.max(n1, n2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i < n1) sb.append(word1.charAt(i));
            if (i < n2) sb.append(word2.charAt(i));
        }
        return sb.toString();
    }
}
