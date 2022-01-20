package topInterviewQs;

// Date: Jan 9, 2022
// 412. Fizz Buzz
// https://leetcode.com/problems/fizz-buzz/

import java.util.ArrayList;
import java.util.List;

// may take a look on another approaches if have time

public class P412 {
    // time complexity: O(n)
    // space complexity: O(1)
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        boolean byThree, byFive;
        for (int i = 1; i <= n; i++) {
            byThree = (i % 3) == 0;
            byFive = (i % 5) == 0;
            if (byThree && byFive) answer.add("FizzBuzz");
            else if (byThree) answer.add("Fizz");
            else if (byFive) answer.add("Buzz");
            else answer.add(Integer.toString(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        P412 obj = new P412();
        System.out.println("Expected: [1, 2, Fizz]\nReceived: " + obj.fizzBuzz(3));
        System.out.println("---");
        System.out.println("Expected: [1, 2, Fizz, 4, Buzz]\nReceived: " + obj.fizzBuzz(5));
    }
}

/*
    Given an integer n, return a string array answer (1-indexed) where:
    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.

    Example 1:
    Input: n = 3
    Output: ["1","2","Fizz"]

    Example 2:
    Input: n = 5
    Output: ["1","2","Fizz","4","Buzz"]
 */

// reference
// https://leetcode.com/problems/fizz-buzz/solution/
