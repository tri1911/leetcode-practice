package leetcodingchallenge.september2022;

/**
 * Date: September 22, 2022
 * 557. Reverse Words in a String III
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */

public class P557 {
    // time: O(n)
    // space: O(1)
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int lastSpaceIdx = -1;
        for (int i = 0; i <= n; i++) {
            if (i == n || arr[i] == ' ') {
                int startIdx = lastSpaceIdx + 1;
                int endIdx = i - 1;
                // reverse the word
                while (startIdx < endIdx) {
                    char tmp = arr[startIdx];
                    arr[startIdx] = arr[endIdx];
                    arr[endIdx] = tmp;
                    startIdx++;
                    endIdx--;
                }
                lastSpaceIdx = i;
            }
        }
        return new String(arr);
    }
}
