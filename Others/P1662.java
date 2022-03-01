package others;

/**
 * Date: Feb 27, 2022
 * 1662. Check If Two String Arrays are Equivalent
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */

public class P1662 {
    // time: O(m + n)
    // space: O(m + n)
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String str : word1) sb1.append(str);
        StringBuilder sb2 = new StringBuilder();
        for (String str : word2) sb2.append(str);
        return sb1.toString().equals(sb2.toString());
    }
}
