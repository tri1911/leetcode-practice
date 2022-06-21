package leetcodingchallenge.june2022;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Date: June 21, 2022
 * 1642. Furthest Building You Can Reach1642. Furthest Building You Can Reach
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 */

public class P1642 {
    // observation: using the ladders for largest height differences (greedily using ladders)1642. Furthest Building You Can Reach
    // time: O(nlog(ladders))
    // space: O(ladders)
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            int dif = heights[i + 1] - heights[i];
            if (dif > 0) pq.offer(dif);
            if (pq.size() > ladders) bricks -= pq.poll();
            if (bricks < 0) return i;
        }
        return n - 1;
    }
}

/**
 * references
 * https://leetcode.com/problems/furthest-building-you-can-reach/discuss/918515/JavaC%2B%2BPython-Priority-Queue
 */