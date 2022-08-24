package topInterviewQs;

/**
 * Date: Jan 12, 2022 - Redo: August 24, 2022
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/
 */

public class P326 {
    // easy to solve with loop, but there is a beautiful approach with O(1)
    // time complexity: O(1)
    // space complexity: O(1)
    public boolean isPowerOfThree(int n) {
        // observation: the maximum valid positive integer (within 32-bit range) is 1162261467
        // which is calculated from 3 power of Math.floor of log3(Integer.MAX_VALUE)
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
         System.out.println(Math.pow(3, Math.floor(Math.log(Integer.MAX_VALUE) / Math.log(3))));
    }
}

/**
 * Reference
 * https://leetcode.com/problems/power-of-three/solution/
 */
