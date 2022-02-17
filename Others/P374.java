package others;

/**
 * Date: Feb 17, 2022
 * 374. Guess Number Higher or Lower
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */

// TODO: check out the ternary search approach in the official solution

public class P374 {
    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */
    private int guess(int num) {
        return 0;
    }

    // binary search approach
    // time: O(log(n))
    // space: O(1)
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = guess((int) mid);
            if (val == 0) return mid;
            else if (val < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
