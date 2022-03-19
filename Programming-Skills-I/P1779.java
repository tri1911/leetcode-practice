package programmingSkills1;

/**
 * Date: March 18, 2022
 * 1779. Find the Nearest Point That Has the Same X or Y Coordinate
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 */

public class P1779 {
    // time: O(n)
    // space: O(1)
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1, currentMinDistance = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int a = points[i][0], b = points[i][1];
            if (a == x || b == y) {
                int distance = Math.abs(a - x) + Math.abs(b - y);
                if (distance < currentMinDistance) {
                    ans = i;
                    currentMinDistance = distance;
                }
            }
        }
        return ans;
    }
}
