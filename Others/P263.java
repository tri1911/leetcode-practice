package others;

/**
 * Date: Feb 17, 2022
 * 263. Ugly Number
 * https://leetcode.com/problems/ugly-number/
 */

public class P263 {
    // time: O(log(n))
    // space: O(1)
    public boolean isUgly(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        return n % 2 == 0 && isUgly(n / 2)
                || n % 3 == 0 && isUgly(n / 3)
                || n % 5 == 0 && isUgly(n / 5);
    }
}
