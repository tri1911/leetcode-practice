package leetcodingchallenge.february2022;

import java.util.PriorityQueue;

/**
 * Date: Feb 19, 2022
 * 1675. Minimize Deviation in Array
 * https://leetcode.com/problems/minimize-deviation-in-array/
 */

// TODO: review to fully understand the solution and check out other appoaches

public class P1675 {
    // time: O(log(n) * n * O(log(m))
    // space: O(n)
    public int minimumDeviation(int[] nums) {
        // observations:
        // - for each position in nums, the possible transformed even value is the max & the possible transformed odd value is the min
        // - the deviation of the array is the difference of the global max and the global min
        // - if there is a better solution then it would be decrease the global max or increase the global min

        // max heap to keep track the global max
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = Integer.MAX_VALUE, globalMin = Integer.MAX_VALUE;
        // transform odd numbers to even numbers to minimize the possible operation to decrease the max only (remove the operation of increasing the global min)
        for (int num : nums) {
            num = num % 2 == 0 ? num : num * 2;
            globalMin = Math.min(globalMin, num);
            pq.offer(num);
        }
        // now,  the pq stores max values, we need to decrease the global max to find better solution
        while (pq.peek() % 2 == 0) {
            int max = pq.poll();
            ans = Math.min(ans, max - globalMin);
            globalMin = Math.min(globalMin, max / 2);
            pq.offer(max / 2);
        }
        return Math.min(ans, pq.peek() - globalMin);
    }
}

/**
 * reference
 * https://leetcode.com/problems/minimize-deviation-in-array/discuss/955262/C%2B%2B-intuitions-and-flip
 */