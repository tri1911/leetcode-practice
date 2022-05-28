package leetcodingchallenge.may2022;

/**
 * Date: May 27, 2022
 * 1342. Number of Steps to Reduce a Number to Zero
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */

public class P1342 {
    // time: O(log(n))
    // space: O(1)
    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int ans = 0;
        while (num != 0) {
            ans += ((num & 1) == 1) ? 2 : 1;
            num >>= 1;
        }
        return ans - 1;
    }
}

/**
 * reference
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/discuss/502809/just-count-number-of-0-and-1-in-binary
 */