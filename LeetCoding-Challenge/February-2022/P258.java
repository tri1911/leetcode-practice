package leetcodingchallenge.february2022;

/**
 * Date: Feb 8, 2022
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/
 */

public class P258 {
    // optimized approach
    // time: O(1)
    // space: O(1)
    public int addDigits(int num) {
        // abc = a * 100 + b * 10 + c = a * (9 * 11 + 1) + b * (9 * 1 + 1) + c = (a + b + c) + 9 * (11 + 1)
        // abc % 9 = (a + b + c) % 9
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
        // OR num == 0 ? 0 : 1 + (num - 1) % 9;
    }

    /*  naive approach
        public int addDigits(int num) {
            int digitalRoot = 0;
            while (num != 0) {
                digitalRoot += num % 10;
                num /= 10;
                if (num == 0 && digitalRoot > 9) {
                    num = digitalRoot;
                    digitalRoot = 0;
                }
            }
            return digitalRoot;
        }
     */

    /*  my first attempt naive approach with loop -> dump one :)
        // time: O(log(n))
        // space: O(1)
        public int addDigits(int num) {
            int ans = num;
            while (ans > 9) {
                ans = helper(ans);
            }
            return ans;
        }

        private int helper(int num) {
            int ans = 0;
            while (num != 0) {
                ans += num % 10;
                num /= 10;
            }
            return ans;
        }
     */
}

/**
 * reference
 * https://leetcode.com/problems/add-digits/solution/
 */