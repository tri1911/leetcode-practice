package leetcodingchallenge.january2022;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: Jan 23, 2022
 * 1291. Sequential Digits
 * https://leetcode.com/problems/sequential-digits/
 */

// TODO: check out other approaches & analyze time complexity (https://www.geeksforgeeks.org/print-all-numbers-from-a-given-range-that-are-made-up-of-consecutive-digits/)

public class P1291 {
    // Brute-Force, Enumeration approach
    // time: O(1)
    // space: O(1)
    public List<Integer> sequentialDigits(int low, int high) {
        int[] sequentialNumbers = {
                12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789, 12345678, 23456789,
                123456789
        };

        List<Integer> ans = new ArrayList<>();
        for (int number : sequentialNumbers) {
            if (number < low) continue;
            if (number > high) break;
            ans.add(number);
        }
        return ans;
    }

    /*  Sliding Window approach
        String digits = "123456789";
        List<Integer> ans = new ArrayList<>();
        int minDigits = String.valueOf(low).length();
        int maxDigits = String.valueOf(high).length();
        int current;
        for (int i = minDigits; i <= maxDigits; i++) {
            for (int j = 0; j < 10 - i; j++) {
                current = Integer.parseInt(digits.substring(j, j + i));
                if (current >= low && current <= high) ans.add(current);
            }
        }
        return ans;
     */

    public static void main(String[] args) {
        P1291 obj = new P1291();
        System.out.println("Expected: [123, 234]. Received: " + obj.sequentialDigits(100, 300));
        System.out.println("Expected: [1234, 2345, 3456, 4567, 5678, 6789, 12345]. Received: " + obj.sequentialDigits(1000, 13000));
    }
}

/*
    Constraints:
    10 <= low <= high <= 10^9
 */

/**
 * reference
 * https://leetcode.com/problems/sequential-digits/discuss/451851/Java-Just-a-joke
 * https://www.youtube.com/watch?v=sFt3KVGyeWw
 */