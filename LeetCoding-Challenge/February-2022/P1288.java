package leetcodingchallenge.february2022;

import java.util.Arrays;

/**
 * Date: Feb 20, 2022
 * 1288. Remove Covered Intervals
 * https://leetcode.com/problems/remove-covered-intervals/
 */

// TODO: check out better implementation when have some time

public class P1288 {
    // time: O(nlog(n))
    // space: O(1)
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        int n = intervals.length, ans = n;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] == intervals[i - 1][0]) {
                ans--;
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
            } else if (intervals[i][1] <= intervals[i - 1][1]) {
                ans--;
                intervals[i] = intervals[i - 1];
            }
        }
        return ans;
    }
}
