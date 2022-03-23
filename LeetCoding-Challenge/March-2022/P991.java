package leetcodingchallenge.march2022;

/**
 * Date: March 23, 2022
 * 991. Broken Calculator
 * https://leetcode.com/problems/broken-calculator/
 */

public class P991 {
    // time: O(log(n))
    // space: O(1)
    public int brokenCalc(int startValue, int target) {
        // from `startValue` to `target`, we have 2 choices each step: -1 or *2
        // instead of going from `startValue` to `target`, we can go backward with 2 choices: +1 or /2
        // then, while target > startValue, for each step we greedily /2
        // if `startValue` is even, (startValue + 1 + 1) / 2 takes more operations than startValue / 2 + 1
        // else `startValue` is odd, (startValue + 1 + 1 + 1) / 2 takes more operations than (startValue + 1) / 2 + 1
        int ans = 0;
        while (target > startValue) {
            ans++;
            if (target % 2 == 1) target += 1;
            else target /= 2;
        }
        return ans + startValue - target;
    }
}

/**
 * reference
 * https://leetcode.com/problems/broken-calculator/solution/
 */