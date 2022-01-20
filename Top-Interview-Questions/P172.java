package topInterviewQs;

// Date: Jan 7, 2022
// 172. Factorial Trailing Zeroes
// https://leetcode.com/problems/factorial-trailing-zeroes/

// TODO: review the solution

public class P172 {
    // time complexity: O(log(n))
    // space complexity: O(1)
    // key idea: count number of 5 (don't need to care about 2's because its frequencies always greater than 5's)
    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0)
            count += n /= 5;
        return count;
    }

    public static void main(String[] args) {
        P172 obj = new P172();
        System.out.println("Expected: 0. Received: " + obj.trailingZeroes(0));
        System.out.println("Expected: 0. Received: " + obj.trailingZeroes(3));
        System.out.println("Expected: 1. Received: " + obj.trailingZeroes(5));
        System.out.println("Expected: 2. Received: " + obj.trailingZeroes(10));
        System.out.println("Expected: 6. Received: " + obj.trailingZeroes(25));
    }
}

// reference
// https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52371/My-one-line-solutions-in-3-languages

/*
    The key idea is count how many 5's are in the factorial.
    So first we add n/5.
    Wait, we are missing 5X5, 2X5X5..., so we add n/25 (why not count as two 5's for each , because one is already counted in n/5).
    Wait, we are missing 5X5X5, 2X5X5X5..., so we add n/125.
    Thus, count = n/5 + n/25 + n/125 + ... + 0
 */