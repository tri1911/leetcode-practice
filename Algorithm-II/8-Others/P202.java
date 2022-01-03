package algorithm2.others;

// Date: Dec 24, 2021
// 202. Happy Number
// https://leetcode.com/problems/happy-number/

import java.util.HashSet;
import java.util.Set;

// TODO: analyze the time & space complexity

public class P202 {
    // approach 1
    public boolean _isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (!seen.contains(n) && n != 1) {
            seen.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    // approach 2 using Floyd's Loop Detection Algorithm
    public boolean isHappy(int n) {
        int slow = n, fast = getNextNumber(n);
        while (fast != 1 && slow != fast) {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }
        return fast == 1;
    }

    // helper function
    private int getNextNumber(int n) {
        int output = 0;
        while (n != 0) {
            output += (n % 10) * (n % 10);
            n /= 10;
        }
        return output;
    }

    public static void main(String[] args) {
        P202 obj = new P202();
        System.out.println("----------------------------");
        System.out.println("Input: n = 19. Expect: true");
        System.out.println("Output: " + obj.isHappy(19));
        System.out.println("----------------------------");
        System.out.println("Input: n = 2. Expect: false");
        System.out.println("Output: " + obj.isHappy(2));
    }
}

// reference
// https://leetcode.com/problems/happy-number/solution/
