package others;

/**
 * Date: March 29, 2022
 * 495. Teemo Attacking
 * https://leetcode.com/problems/teemo-attacking/
 */

public class P495 {
    // time: O(n)
    // space: O(1)
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // 1 -> 5 (= 1 + 5 - 1)
        // if next start is 6 then ans += duration
        // otherwise, if the next start is <= 5: e.g.
        // 5 then ans += 5 - 1 = 4
        // 4 then ans += 4 - 1 = 3
        int ans = 0;
        for (int i = 1; i < timeSeries.length; i++)
            ans += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        return ans + duration;
    }
}
