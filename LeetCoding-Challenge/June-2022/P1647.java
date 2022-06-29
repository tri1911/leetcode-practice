package leetcodingchallenge.june2022;

import java.util.Arrays;

public class P1647 {
    // time: O(n) - count characters takes n times + sort array of 26 elements is constant
    // space: O(1) - extra space always O(26)
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) count[ch - 'a']++;
        Arrays.sort(count);
        int maxValid = s.length(), stepCount = 0;
        for (int i = 25; i >= 0 && count[i] > 0; i--) {
            if (count[i] > maxValid) {
                stepCount += count[i] - maxValid;
                count[i] = maxValid;
            }
            maxValid = Math.max(0, count[i] - 1);
        }
        return stepCount;
    }
}

/**
 * references
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/solution/
 */