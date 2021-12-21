package algorithm2.twoPointers;

// date: Dec 17, 2021
// 986. Interval List Intersections
// https://leetcode.com/problems/interval-list-intersections/

import java.util.*;

public class P986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int n1 = firstList.length, n2 = secondList.length;
        if (n1 == 0 || n2 == 0) return new int[][]{};
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end;
            if (firstList[i][1] < secondList[j][1]) {
                end = firstList[i++][1];
            } else {
                end = secondList[j++][1];
            }
            if (start <= end) {
                ans.add(new int[]{start, end});
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        P986 p = new P986();
        int[][] result = p.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        System.out.println("Expected: [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]\nOutput: " + Arrays.deepToString(result));

        result = p.intervalIntersection(new int[][]{{1, 3}, {5, 9}}, new int[][]{});
        System.out.println("Expected: []\nOutput: " + Arrays.deepToString(result));

        result = p.intervalIntersection(new int[][]{}, new int[][]{{4, 8}, {10, 12}});
        System.out.println("Expected: []\nOutput: " + Arrays.deepToString(result));

        result = p.intervalIntersection(new int[][]{{1, 7}}, new int[][]{{3, 10}});
        System.out.println("Expected: [[3, 7]]\nOutput: " + Arrays.deepToString(result));
    }
}

// reference
// https://stackoverflow.com/questions/10043209/convert-arraylist-into-2d-array-containing-varying-lengths-of-arrays