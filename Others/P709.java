package others;

/**
 * Date: Feb 26, 2022
 * 709. To Lower Case
 * https://leetcode.com/problems/to-lower-case/
 */

public class P709 {
    // time: O(n)
    // space: O(n)
    public String toLowerCase(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += 'a' - 'A';
            }
        }
        return new String(arr);
    }
}
