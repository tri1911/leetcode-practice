package leetcodingchallenge.august2022;

import java.util.Arrays;

/**
 * Date: August 26, 2022
 * 869. Reordered Power of 2
 * https://leetcode.com/problems/reordered-power-of-2/
 */

public class P869 {
    // compare the digits count of n to the digits count of all valid power of 2
    // time: O(log(n)^2) - which is log2(n) power of 2 & counting the digits takes O(log10(n))
    public boolean reorderedPowerOf2(int n) {
        int[] counts = digitsCount(n);
        // compare the digit counts with all possible power of 2
        // Math.floor(log2(10^9)) is 29
        for (int k = 0; k <= 29; k++) {
            if (Arrays.equals(counts, digitsCount(1 << k))) {
                return true;
            }
        }
        return false;
    }

    // helper function to count digits
    // time: O(log(n))
    private int[] digitsCount(int n) {
        int[] counts = new int[10];
        while (n != 0) {
            counts[n % 10]++;
            n /= 10;
        }
        return counts;
    }
}

/**
 * References
 * https://leetcode.com/problems/reordered-power-of-2/solution/
 */
