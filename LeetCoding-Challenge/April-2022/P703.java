package leetcodingchallenge.april2022;

import java.util.PriorityQueue;

/**
 * Date: April 08, 2022
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */

public class P703 {
    private PriorityQueue<Integer> pq;
    private int size;

    // own solution
    // time: O(n*log(n))
    // space: O(k)
    public P703(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;
        for (int num : nums) add(num);
    }

    // time: O(log(n))
    public int add(int val) {
        if (size > 0) {
            pq.offer(val);
            size--;
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
