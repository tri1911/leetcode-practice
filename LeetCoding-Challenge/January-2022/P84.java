package leetcodingchallenge.january2022;

import java.util.ArrayDeque;

/**
 * Date: Jan 29, 2022
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */

// TODO: check out the better implementation

// observation: the largest rectangle includes at least 1 bar in full
// so, we need to find the largest rectangle for each bar which participate in full
// then the solution would be the largest among these largest
// the main point is how to find the largest rectangle for each bar
// => find left limit and right limit (the first smaller on the left & right)
// => use monotonic stack
public class P84 {
    // time: O(n)
    // space: O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // find limits - takes O(n)
        ArrayDeque<Integer> leftStack = new ArrayDeque<>(); // or can use 1 stack that contains pairs of limits
        ArrayDeque<Integer> rightStack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            // update left limit
            while (!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[i]) leftStack.pop();
            left[i] = leftStack.isEmpty() ? 0 : leftStack.peek() + 1;
            leftStack.push(i);
            // update right limit
            while (!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[n - 1 - i]) rightStack.pop();
            right[n - 1 - i] = rightStack.isEmpty() ? n - 1 : rightStack.peek() - 1;
            rightStack.push(n - 1 - i);
        }
        // find the solution - takes O(n)
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, heights[i] * (right[i] - left[i] + 1));
        return ans;
    }

    public static void main(String[] args) {
        P84 obj = new P84();
        System.out.println("Expected: 10. Received: " + obj.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println("Expected: 4. Received: " + obj.largestRectangleArea(new int[]{2, 4}));
    }
}

/**
 * reference
 * https://www.youtube.com/watch?v=vcv3REtIvEo&t=85s
 */