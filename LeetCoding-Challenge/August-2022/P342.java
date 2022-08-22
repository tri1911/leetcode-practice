package leetcodingchallenge.august2022;

/**
 * Date: August 22, 2022
 * 342. Power of Four
 * https://leetcode.com/problems/power-of-four/
 */

public class P342 {
    // bit manipulation approach
    // the valid 32-bit integer should have single 1 bit at odd positions
    // e.g. 100, 10000, 1000000
    // time & space: O(1)
    public boolean isPowerOfFour(int n) {
        return (n > 0) && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}

/**
 * reference
 * https://leetcode.com/problems/power-of-four/discuss/80457/Java-1-line-(cheating-for-the-purpose-of-not-using-loops)
 */

