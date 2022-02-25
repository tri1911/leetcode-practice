package others;

/**
 * Date: Feb 25, 2022
 * 441. Arranging Coins
 * https://leetcode.com/problems/arranging-coins/
 */

public class P441 {
    // use binary search
    // OR can use math -> time = O(1)
    // time: O(log(n))
    // space: O(1)
    public int arrangeCoins(int n) {
        long low = 1, high = n;
        long mid;
        while (low <= high) {
            mid = (low + high) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum > n) high = mid - 1;
            else if (sum < n) low = mid + 1;
            else return (int) mid;
        }
        return (int) high;
    }
}

/**
 * reference
 * https://leetcode.com/problems/arranging-coins/solution/
 */