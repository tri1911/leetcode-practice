package others;

/**
 * Date: Feb 8, 2022
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 */

public class P58 {
    // time: O(n)
    // space: O(1)
    public int lengthOfLastWord(String s) {
        int last = s.length() - 1;
        while (last >= 0 && s.charAt(last) == ' ') last--;
        int first = last;
        while (first >= 0 && s.charAt(first) != ' ') first--;
        return last - first;
    }
}
