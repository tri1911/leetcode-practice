package leetcodingchallenge.january2022;

// Daily Challenge - Jan 4, 2022
// Date: Jan 3, 2022
// the same as Problem 476

// 5 is 101 -> its complement is 010
// Observation: 101 XOR 010 = 111
// And, 101 XOR 111 = 010
public class P1009 {
    // time complexity: O(log(n))
    // space complexity: O(1)
    public int bitwiseComplement(int n) {
        /* my implementation
            if (n == 0) return 1;
            int mask = 0;
            int tmp = n;
            while (tmp != 0) {
                mask = (mask << 1) ^ 1;
                tmp >>= 1;
            }
            return n ^ mask;
         */
        int mask = 1;
        while (mask < n) mask = (mask << 1) ^ 1;
        return mask ^ n;
    }

    public static void main(String[] args) {
        P1009 obj = new P1009();
        System.out.println("Expected: 2. Received: " + obj.bitwiseComplement(5));
        System.out.println("Expected: 0. Received: " + obj.bitwiseComplement(7));
        System.out.println("Expected: 5. Received: " + obj.bitwiseComplement(10));
        System.out.println("Expected: 1. Received: " + obj.bitwiseComplement(0));
    }
}

// reference
// https://leetcode.com/problems/complement-of-base-10-integer/discuss/1665225/Daily-LeetCoding-Challenge-January-Day-4
/*
    while(mask < n) mask = (mask << 1) + 1;
    return mask ^ n;
 */