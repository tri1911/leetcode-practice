package leetcodingchallenge.may2022;

/**
 * Date: May 30, 2022
 * 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/
 */

// TODO: review the corner case (error-prone)

public class P29 {
    // time: O(log(n))
    // space: O(1)
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // OR
        // if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        int ans = 0, a = Math.abs(dividend), b = Math.abs(divisor);
        // cannot use (a >= b) => error: when dividend is MIN_VALUE -> abs(dividend) = MIN_VALUE
        while (a - b >= 0) {
            int shift = 0;
            // cannot use (a >= (b << shift << 1)) => error: when shift = 31
            while (a - (b << shift << 1) >= 0) shift++;
            a -= b << shift; // update the dividend value
            ans += 1 << shift; // add the calculated quotient to the `solution`
        }
        return (dividend > 0) == (divisor > 0) ? ans : -ans;
    }
}

/**
 * references
 * https://leetcode.com/problems/divide-two-integers/discuss/13407/C%2B%2B-bit-manipulations
 * https://leetcode.com/problems/divide-two-integers/discuss/142849/C%2B%2BJavaPython-Should-Not-Use-%22long%22-Int
 */