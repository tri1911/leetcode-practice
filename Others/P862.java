package others;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: Feb 19, 2022
 * 862. Shortest Subarray with Sum at Least K
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 */

// TODO: review and redo

public class P862 {
    // time: O(n)
    // space: O(n)
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // compute pre-sum
        long[] ps = new long[n + 1];
        for (int i = 1; i <= n; i++)
            ps[i] = ps[i - 1] + nums[i - 1];
        // - if x1 < x2 and ps[x1] >= ps[x2] then don't care x1
        // => the candidates should be in increasing order in term of ps[i]
        // - if solution(y) = x then solution(y + 1) excludes x
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && ps[stack.peek()] >= ps[i])
                stack.pop();
            while (!stack.isEmpty() && ps[i] - ps[stack.getLast()] >= k)
                ans = Math.min(ans, i - stack.removeLast());
            stack.push(i);
        }
        return ans == n + 1 ? -1 : ans;
    }

    public static void main(String[] args) {
        P862 obj = new P862();
        System.out.println("Expected: 1. Received: " + obj.shortestSubarray(new int[]{1}, 1));
        System.out.println("Expected: 2. Received: " + obj.shortestSubarray(new int[]{48, 99, 37, 4, -31}, 140));
        System.out.println("Expected: 2. Received: " + obj.shortestSubarray(new int[]{2, -1, 2}, 3));
    }
}

/**
 * reference
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/solution/
 */