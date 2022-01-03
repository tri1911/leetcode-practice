package algorithm2.bitManipulation;

// Date: Dec 25, 2021
// 201. Bitwise AND of Numbers Range
// https://leetcode.com/problems/bitwise-and-of-numbers-range/

public class P201 {
    // use Brian Kernighan's Algorithm
    // reference
    // https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/593317/Simple-3-line-Java-solution-faster-than-100
    // https://iq.opengenus.org/brian-kernighan-algorithm/
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) right &= right - 1;
        return right;
    }

    public static void main(String[] args) {
        P201 obj = new P201();
        System.out.println("---------------------");
        System.out.println("Input: left = 5, right = 7. Expect: 4");
        System.out.println("Output: " + obj.rangeBitwiseAnd(5, 7));
        System.out.println("---------------------");
        System.out.println("Input: left = 0, right = 0. Expect: 0");
        System.out.println("Output: " + obj.rangeBitwiseAnd(0, 0));
        System.out.println("---------------------");
        System.out.println("Input: left = 1, right = 2147483647. Expect: 0");
        System.out.println("Output: " + obj.rangeBitwiseAnd(1, 2147483647));
    }
}

// reference
// https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/56729/Bit-operation-solution(JAVA)
