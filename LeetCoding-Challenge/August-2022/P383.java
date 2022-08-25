package leetcodingchallenge.august2022;

/**
 * Date: August 25, 2022 (Redo, already solved it in C++ already)
 * 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/
 */

public class P383 {
    // time: O(n)
    // space: O(1)
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counter = new int[26];
        for (char ch : magazine.toCharArray()) {
            counter[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (--counter[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
