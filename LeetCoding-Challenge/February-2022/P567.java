package leetcodingchallenge.february2022;

/**
 * Date: Feb 11, 2022
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/
 */

// TODO: check out the official solution if have time

public class P567 {
    // sliding window approach
    // time: O(n)
    // space: O(1)
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;
        int[] counter = new int[26];
        for (int i = 0; i < n1; i++) counter[s1.charAt(i) - 'a']++;
        int target = n1;
        for (int i = 0; i < n1; i++)
            if (--counter[s2.charAt(i) - 'a'] >= 0) target--;
        if (target == 0) return true;
        for (int i = n1; i < n2; i++) {
            if (--counter[s2.charAt(i) - 'a'] >= 0) target--;
            if (counter[s2.charAt(i - n1) - 'a']++ >= 0) target++;
            if (target == 0) return true;
        }
        return false;
    }
}
