package leetcodingchallenge.april2022;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class P1046 {
    // time: n*log(n)
    // space: O(n)
    public int lastStoneWeight(int[] stones) {
        // need to get 2 stones with max weights -> use max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        // build heap takes n*log(n)
        for (int stone : stones) maxHeap.offer(stone);
        // playing game takes n*log(n)
        while (maxHeap.size() > 1) {
            int dif = maxHeap.poll() - maxHeap.poll();
            if (dif != 0) maxHeap.offer(dif);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    // smart approach
    public int _lastStoneWeight(int[] stones) {
        int n = stones.length;
        while (n > 1) {
            Arrays.sort(stones);
            stones[n - 2] = stones[n - 1] - stones[n - 2];
            n--;
        }
        return stones[0];
    }
}

/**
 * reference
 * https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html
 */
