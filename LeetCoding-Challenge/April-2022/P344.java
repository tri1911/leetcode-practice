package leetcodingchallenge.april2022;

/**
 * Date: April 01, 2022
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 */

public class P344 {
    // time: O(n)
    // space: O(1)
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
