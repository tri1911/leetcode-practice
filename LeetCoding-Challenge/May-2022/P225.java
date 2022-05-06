package leetcodingchallenge.may2022;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: May 05, 2022
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 */

 // TODO: implement with the # Approach 2

public class P225 {
    private Deque<Integer> queue;

    public P225() {
        queue = new ArrayDeque<>();
    }

    // time: O(n)
    // space: O(1)
    public void push(int x) {
        queue.add(x);
        int n = queue.size();
        for (int i = 0; i < n - 1; i++) queue.add(queue.remove());
    }

    // time: O(1)
    public int pop() {
        return queue.remove();
    }

    // time: O(1)
    public int top() {
        return queue.peek();
    }

    // time: O(1)
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * references
 * https://leetcode.com/problems/implement-stack-using-queues/solution/
 */