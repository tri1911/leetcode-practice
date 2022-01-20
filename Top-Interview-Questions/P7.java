package topInterviewQs;

// Date: Dec 27, 2021
// 7. Reverse Integer
// https://leetcode.com/problems/reverse-integer/

public class P7 {
    // time complexity: O(log(n))
    // space complexity: O(1)
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int last = x % 10;
            x /= 10;
            if (ans > Integer.MAX_VALUE / 10 ||
                ans == Integer.MAX_VALUE / 10 && last > 7 ||
                ans < Integer.MIN_VALUE / 10 ||
                ans == Integer.MIN_VALUE / 10 && last < -8)
                return 0;
            ans = ans * 10 + last;
        }
        return ans;
    }
}

// reference
// https://leetcode.com/problems/reverse-integer/solution/
