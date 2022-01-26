package topInterviewQs;

import java.util.ArrayDeque;

/**
 * Date: Jan 26, 2022
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/
 */

public class P227 {
    // optimized approach (without using stack)
    // in the approach using stack, we notice that the main task of stack is saving the first operand in arithmetic operation
    // in order to evaluate later
    // now, instead of saving it into stack, we record the first operand into a variable - optimize to use only O(1) space
    // time: O(n)
    // space: O(1)
    public int calculate(String s) {
        int n = s.length();
        // at the beginning, we can assume first = 0, and operation is +
        // e.g. "1 + 2" is seen as 0 + "1 + 2"
        int first = 0, second = 0;
        char operation = '+';
        // the trick is if the previous operation is '+' or '-', we add the "first" into the answer
        // otherwise, we evaluate that operation ('*' or '/') and assign it to "first" (remember update the operation as well)
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char currentCharacter = s.charAt(i);
            if (Character.isDigit(currentCharacter)) {
                second = second * 10 + (currentCharacter - '0');
            }
            if (!(Character.isDigit(currentCharacter) || Character.isWhitespace(currentCharacter)) || i == n - 1) {
                if (operation == '+' || operation == '-') {
                    ans += first;
                    first = operation == '+' ? second : -second;
                } else if (operation == '*') {
                    first = first * second;
                } else if (operation == '/') {
                    first = first / second;
                }
                second = 0;
                operation = currentCharacter;
            }
        }
        return ans + first;
    }

    /*  using stack approach - time: O(n) & space: O(n)
        int n = s.length();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }
            // if arithmetic operator or the end of string is met
            // then considering the previous operator to decide whether the current expression will be evaluated
            if (!(Character.isDigit(ch) || Character.isWhitespace(ch)) || i == n - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                currentNumber = 0;
                operation = ch;
            }
        }
        int ans = 0;
        for (int val : stack) ans += val;
        return ans;
     */

    public static void main(String[] args) {
        P227 obj = new P227();
        System.out.println("Expected: 7. Received: " + obj.calculate("3+2*2"));
        System.out.println("Expected: 1. Received: " + obj.calculate(" 3/2 "));
        System.out.println("Expected: 5. Received: " + obj.calculate(" 3+5 / 2 "));
    }
}

/**
 * reference
 * https://leetcode.com/problems/basic-calculator-ii/solution/
 */