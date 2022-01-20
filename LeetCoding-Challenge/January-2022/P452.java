package leetcodingchallenge.january2022;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Date: Jan 13, 2022
 * 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */

public class P452 {

    /*
        sort points (rename as intervals) by its start or end point -> use end point here
        iterate through intervals
             for the current interval we are examining, we burst at the most right point (end point)
             the next interval, we compare the start point to the previous point we burst
                 if start point < previous burst point then we move on
                 else we need burst
     */

    // greedy algorithm
    // time complexity: O(n)
    // space complexity: O(1)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        int answer = 1;
        int previousBurstPoint = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > previousBurstPoint) {
                previousBurstPoint = points[i][1];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        P452 obj = new P452();
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        System.out.println("Expected: 2. Received: " + obj.findMinArrowShots(points));
    }
}

/**
 * reference
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/discuss/93703/Share-my-explained-Greedy-solution
 */
