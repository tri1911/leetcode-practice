package programmingSkills1;

/**
 * Date: March 16, 2022
 * 1281. Subtract the Product and Sum of Digits of an Integer
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */

public class P1281 {
    // time: O(log(n))
    // space: O(1)
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        while (n != 0) {
            int digit = n % 10;
            product *= digit;
            sum += digit;
            n /= 10;
        }
        return product - sum;
    }
}
