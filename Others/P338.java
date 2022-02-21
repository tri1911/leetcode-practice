package others;

/**
 * Date: Feb 20, 2022
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/
 */

public class P338 {
    // time: O(n)
    // space: O(1)
    public int[] countBits(int n) {
        // observation:
        // from an integer, we can generate 2 possible new values
        // 1. double it OR move bits to left by 1 (<< 1)
        // 2. double it and plus 1 to the last bit
        // conversely, we can find out the info from the current by the half of it
        // this is dynamic programming
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) ans[i] = ans[i >> 1] + (i & 1);
        return ans;
    }
}

/**
 * reference
 * https://leetcode.com/problems/counting-bits/discuss/79539/Three-Line-Java-Solution
 */
