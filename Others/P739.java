package others;

import java.util.ArrayDeque;

/**
 * Date: Jan 24, 2022
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 */

// TODO: spend time to read official solution article (monotonic stack concept & optimal solution with space O(1))

public class P739 {
    // time: O(n) since each element is pushed and popped at most once
    // space: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return answer;
    }
}

/**
 * reference
 * https://leetcode.com/problems/daily-temperatures/solution/
 */