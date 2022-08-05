package leetcodingchallenge.august2022;

/**
 * Date: August 04, 2022
 * 858. Mirror Reflection
 * https://leetcode.com/problems/mirror-reflection/
 */

// TODO: redo to truly understand

public class P858 {
    // time: O(log(n))
    // space: O(1)
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p >>= 1;
            q >>= 1;
        }
        return 1 - p % 2 + q % 2;
    }
}

/**
 * reference
 * https://leetcode.com/problems/mirror-reflection/discuss/141773
 * https://leetcode.com/problems/mirror-reflection/discuss/146336
 */