package programmingSkills1;

import java.util.Arrays;

/**
 * Date: March 22, 2022
 * 953. Verifying an Alien Dictionary
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */

public class P953 {
    // time: O(m + n) where m is total characters in words, n is the length of order string
    // space: O(1)
    public boolean isAlienSorted(String[] words, String order) {
        int[] hash = new int[26];
        for (int i = 0; i < 26; i++) hash[order.charAt(i) - 'a'] = i;
        for (int i = 0; i < words.length - 1; i++) {
            char[] word1 = words[i].toCharArray(), word2 = words[i + 1].toCharArray();
            int len1 = word1.length, len2 = word2.length, j = 0;
            while (j < len1 && j < len2 && word1[j] == word2[j]) j++;
            if (j == len1) continue;
            if (j == len2 || hash[word1[j] - 'a'] > hash[word2[j] - 'a']) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        P953 obj = new P953();
        System.out.println("Expected: true. Received: " + obj.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println("Expected: false. Received: " + obj.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println("Expected: false. Received: " + obj.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println("Expected: true. Received: " + obj.isAlienSorted(new String[]{"app", "apple"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println("Expected: true. Received: " + obj.isAlienSorted(new String[]{"hello", "hello"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
