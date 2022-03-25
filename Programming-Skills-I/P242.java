package programmingSkills1;

/**
 * Date: March 24, 2022
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 */

public class P242 {
    // time: O(n)
    // space: O(n)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) hash[ch - 'a']++;
        for (char ch : t.toCharArray()) if (--hash[ch - 'a'] < 0) return false;
        return true;
    }
}
