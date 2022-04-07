package topInterviewQs;

import java.util.*;

/**
 * Date: April 06, 2022
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */

public class P150 {
    // time: O(n)
    // space: O(n)
    public int evalRPN(String[] tokens) {
        // Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            // if (!ops.contains(token)) {
            if (!isValidOp(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(evaluate(a, b, token));
            }
        }
        return stack.pop();
    }

    private boolean isValidOp(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int evaluate(int a, int b, String op) {
        int result;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                result = a / b;
        }
        return result;
    }

    // another concise implementation
    public int _evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

/**
 * reference
 * https://youtu.be/84BsI5VJPq4
 */