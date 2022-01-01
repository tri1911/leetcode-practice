package algorithm2.dynamicProgramming;

// date: Dec 23, 2021
// 91. Decode Ways
// https://leetcode.com/problems/decode-ways/

public class P91 {
    // time complexity: O(n)
    // space complexity: O(1)
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        // all possible decoded arrays only end with 1-digit number (e.g. 12, 23, 2)
        // or 2 digit (e.g. 12, 23, 2, 14)
        int oneDigits = 1, twoDigits = 0;
        for (int i = 1; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';
            if (cur == 0) {
                if (prev == 1 || prev == 2) {
                    twoDigits = oneDigits;
                    oneDigits = 0;
                } else {
                    return 0;
                }
            } else {
                int tmp = oneDigits;
                oneDigits += twoDigits;
                if (prev * 10 + cur <= 26) {
                    twoDigits = tmp;
                } else {
                    twoDigits = 0;
                }
            }
        }
        return oneDigits + twoDigits;
    }

    public static void main(String[] args) {
        P91 p = new P91();
        System.out.println("---------------------");
        System.out.println("Input: s = 12. Expect: 2");
        System.out.println("Output: " + p.numDecodings("12"));
        System.out.println("---------------------");
        System.out.println("Input: s = 226. Expect: 3");
        System.out.println("Output: " + p.numDecodings("226"));
        System.out.println("---------------------");
        System.out.println("Input: s = 06. Expect: 0");
        System.out.println("Output: " + p.numDecodings("06"));
    }
}
