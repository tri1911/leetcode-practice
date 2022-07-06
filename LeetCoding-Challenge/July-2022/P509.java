package leetcodingchallenge.july2022;

/**
 * Date: July 06, 2022
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 */

public class P509 {
    // time: O(n)
    // space: O(1)
    public int fib(int n) {
        if (n == 0) return 0;
        int n1 = 0, n2 = 1;
        for (int i = 2;  i <= n; i++) {
            int tmp = n2;
            n2 += n1;
            n1 = tmp;
        }
        return n2;
    }
}
