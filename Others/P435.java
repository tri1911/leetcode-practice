package others;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Date: Jan 13, 2022
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/
 * <p>
 * similar to
 * 56 Merge Intervals
 * 252 Meeting Rooms
 * 253 Meeting Rooms II
 * 452 Minimum Number of Arrows to Burst Balloons
 */

// TODO: check out the better solution
// https://en.wikipedia.org/wiki/Interval_scheduling#Interval_Scheduling_Maximization
// the problem is the same as Given a collection of intervals, find the maximum number of intervals that are non-overlapping.

public class P435 {
    // own solution using greedy algorithm
    // time complexity: O(n*log(n))
    // space complexity: O(1)
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int ans = 0, previous = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (previous > intervals[i][0])
                ans++;
            else
                previous = intervals[i][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        P435 obj = new P435();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Expected: 1. Received: " + obj.eraseOverlapIntervals(intervals));
        System.out.println("---");
        intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Expected: 2. Received: " + obj.eraseOverlapIntervals(intervals));
        System.out.println("---");
        intervals = new int[][]{{1, 2}, {2, 3}};
        System.out.println("Expected: 0. Received: " + obj.eraseOverlapIntervals(intervals));
        System.out.println("---");
        intervals = new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println("Expected: 2. Received: " + obj.eraseOverlapIntervals(intervals));
    }
}

/**
 * reference
 * https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
 */