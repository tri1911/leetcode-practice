package others;

// Date: Jan 6, 2022
// 9. Palindrome Number
// https://leetcode.com/problems/palindrome-number/

public class P9 {
    // without converting from number to string
    // time complexity: O(log(n))
    // space complexity: O(1)
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tmp = x;
        int y = 0;
        while (tmp != 0) {
            y = y * 10 + tmp % 10;
            tmp /= 10;
        }
        return y == x;
    }
}
