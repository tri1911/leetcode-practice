package algorithm2.others;

// Date: Dec 25, 2021
// 149. Max Points on a Line
// https://leetcode.com/problems/max-points-on-a-line/

import java.util.HashMap;
import java.util.Map;

// TODO: check out the Leetcode Solutions
// https://leetcode.com/problems/max-points-on-a-line/discuss/47113/A-java-solution-with-notes
// https://leetcode.com/problems/max-points-on-a-line/solution/

public class P149 {
    // time complexity: O(n*n)
    // space complexity: O(n)
    public int maxPoints(int[][] points) {
        int ans = 1;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> counter = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                double slope = Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]);
                counter.put(slope, counter.getOrDefault(slope, 1) + 1);
                ans = Math.max(ans, counter.get(slope));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P149 obj = new P149();
        System.out.println("---------------------");
        System.out.println("Input: points = [[1, 1], [2, 2], [3, 3]]. Expect: 3");
        System.out.println("Output: " + obj.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println("---------------------");
        System.out.println("Input: points = [[1, 1], [3, 2], [5, 3], [4, 1], [2, 3], [1, 4]]. Expect: 4");
        System.out.println("Output: " + obj.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }
}

