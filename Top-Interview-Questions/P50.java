package topInterviewQs;

/**
 * Date: April 07, 2022
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 */

// TODO: redo

public class P50 {
    // time: O(log(n)) (reduce T(n) -> T(n/2))
    // space: O(1)
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            // if n is Integer.MIN_VALUE -> overflow since -n would be Integer.MAX_VALUE + 1
            // n = -n;
            // x = 1 / x;
            // instead, doing like this
            return (1 / x) * myPow(1 / x, -(n + 1));
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

/**
 * reference
 * https://leetcode.com/problems/powx-n/discuss/19546/Short-and-easy-to-understand-solution
 */
