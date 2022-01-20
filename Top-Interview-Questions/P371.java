package topInterviewQs;

// Date: Dec 29, 2021
// 371. Sum of Two Integers
// https://leetcode.com/problems/sum-of-two-integers/

public class P371 {
    public int getSum(int a, int b) {
        // add a and b by using bitwise operators
        // use XOR to add a and b without carrying
        // use AND to count carrying bits
        // getSum of 2 above results to come up the solution til carrying bits are zeros
        // (a ^ b) ^ ((a & b) << 1)
        int c; // represents carrying bits
        while (b != 0) {
            c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        P371 obj = new P371();
        System.out.println("Expect: 3. Output: " + obj.getSum(1, 2));
        System.out.println("Expect: 5. Output: " + obj.getSum(2, 3));
    }
}

// reference
// https://leetcode.com/problems/sum-of-two-integers/discuss/132479/Simple-explanation-on-how-to-arrive-at-the-solution
// https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary%3A-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
// http://graphics.stanford.edu/~seander/bithacks.html