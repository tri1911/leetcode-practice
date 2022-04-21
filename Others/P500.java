package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: April 20, 2022
 * 500. Keyboard Row
 * https://leetcode.com/problems/keyboard-row/
 */

public class P500 {
    // time: O(n)
    // space: O(1)
    public String[] findWords(String[] words) {
        // set key value for characters in each row
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[] letters = new int[26];
        for (int i = 0; i < 3; i++) {
            char[] arr = rows[i].toCharArray();
            for (char ch : arr) {
                letters[ch - 'a'] = i;
            }
        }
        // calculate the solution
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            String tmp = word.toLowerCase();
            int key = letters[tmp.charAt(0) - 'a'];
            boolean isValid = true;
            for (char ch : tmp.toCharArray()) {
                if (letters[ch - 'a'] != key) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) ans.add(word);
        }
        return ans.toArray(new String[0]);
    }
}
