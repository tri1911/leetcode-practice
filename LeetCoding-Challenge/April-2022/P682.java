package leetcodingchallenge.april2022;

/**
 * Date: April 10, 2022
 * 682. Baseball Game
 * https://leetcode.com/problems/baseball-game/
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class P682 {
    // time: O(n)
    // space: O(n)
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int x = stack.pop();
                int y = stack.peek();
                stack.push(x);
                stack.push(x + y);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        return stack.stream().reduce(0, (subtotal, element) -> subtotal + element);
    }
}
