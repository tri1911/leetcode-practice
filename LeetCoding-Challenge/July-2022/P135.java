package leetcodingchallenge.july2022;

import java.util.Arrays;

/**
 * Date: July 04, 2022
 * 135. Candy
 * https://leetcode.com/problems/candy/
 */

// TODO: re-read the official solution (approach 4)

public class P135 {
    // time & space: O(n)
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        // left-to-right update
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        // right-to-left update
        int ans = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
            ans += candies[i];
        }
        return ans;
    }
}

/**
 * references
 * https://leetcode.com/problems/candy/solution/
 */