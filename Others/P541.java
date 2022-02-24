package others;

/**
 * Date: Feb 23, 2022
 * 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/
 */

public class P541 {
    // time: O(n)
    // space: O(1)
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] ans = s.toCharArray();
        for (int start = 0; start < n; start += 2 * k) {
            int left = start, right = Math.min(left + k - 1, n - 1);
            while (left < right) {
                char tmp = ans[left];
                ans[left++] = ans[right];
                ans[right--] = tmp;
            }
        }
        return new String(ans);
    }
}
