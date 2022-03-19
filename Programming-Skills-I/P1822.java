package programmingSkills1;

/**
 * Date: March 19, 2022
 * 1822. Sign of the Product of an Array
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 */

public class P1822 {
    // time: O(n)
    // space: O(1)
    public int arraySign(int[] nums) {
        boolean isPositive = true;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) isPositive = !isPositive;
        }
        return isPositive ? 1 : -1;
    }

    public static void main(String[] args) {
        P1822 obj = new P1822();
        System.out.println("Expected: -1. Received: " + obj.arraySign(new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41}));
        System.out.println("Expected: -1. Received: " + obj.arraySign(new int[]{9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24}));
    }
}
