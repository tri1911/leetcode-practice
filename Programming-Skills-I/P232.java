package programmingSkills1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: March 25, 2022
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */

public class P232 {
    Deque<Integer> stackToPush;
    Deque<Integer> stackToPop;
    int front; // variable is used to refer to the top when `stackToPop` is empty (other words, elements are not moved to it)

    public P232() {
        stackToPush = new ArrayDeque<>();
        stackToPop = new ArrayDeque<>();
    }

    // time: O(1)
    public void push(int x) {
        if (stackToPush.isEmpty()) front = x; // when both `stackToPush` & `stackToPop` is empty, set x into the `front`
        stackToPush.push(x);
    }

    // time: O(n), but amortized time is O(1)
    public int pop() {
        if (stackToPop.isEmpty()) while (!stackToPush.isEmpty()) stackToPop.push(stackToPush.pop());
        return stackToPop.pop();
    }

    // time: O(1)
    public int peek() {
        if (stackToPop.isEmpty()) return front; // when all elements are in `stackToPush`
        return stackToPop.peek(); // when first elements are in `stackToPop`
    }

    // time: O(1)
    public boolean empty() {
        return stackToPush.isEmpty() && stackToPop.isEmpty();
    }
}
