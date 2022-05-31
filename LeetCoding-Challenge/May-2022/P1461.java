package leetcodingchallenge.may2022;

/**
 * Date: May 31, 2022
 * 1461. Check If a String Contains All Binary Codes of Size K
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */

 // TODO: checkout the official solution article

public class P1461 {
    // time: O(n + k)
    // space: O(k)
    public boolean hasAllCodes(String s, int k) {
        int size = (int) Math.pow(2, k), hashVal = 0, uniqueCount = 0, len = s.length();
        if (len < k) return false;
        // takes O(k) space
        boolean[] seen = new boolean[size];
        // takes O(k) time
        for (int i = 0; i < k; i++) {
            hashVal = 2 * hashVal + (s.charAt(i) - '0');
        }
        seen[hashVal] = true;
        uniqueCount++;
        // takes O(n) time
        for (int i = k; i < len; i++) {
            int base = ((int) Math.pow(2, k - 1));
            int first = s.charAt(i - k) - '0';
            hashVal -= base * first;
            hashVal *= 2;
            hashVal += s.charAt(i) - '0';
            if (!seen[hashVal]) {
                seen[hashVal] = true;
                uniqueCount++;
            }
        }
        return uniqueCount == size;
    }
}

/**
 * references
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/solution/
 */

 /* 8ms solution
    public static boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        boolean[] got = new boolean[need];
        int allOne = need - 1;
        int hashVal = 0;

        for (int i = 0; i < s.length(); i++) {
            // calculate hash for s.substr(i-k+1,i+1)
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');
            // hash only available when i-k+1 > 0
            if (i >= k - 1 && !got[hashVal]) {
                got[hashVal] = true;
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
*/
