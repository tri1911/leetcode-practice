package leetcodingchallenge.january2022;

/**
 * Date: Jan 14, 2022
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/
 */

// TODO: check out the official solution if have time

public class P8 {
    // my own solution
    // time: O(n)
    // space: O(1)
    public int myAtoi(String s) {
        int n = s.length(), ans = 0;
        int sign = 1;
        int current = 0;
        while (current < n && s.charAt(current) == ' ') current++;
        if (current < n && s.charAt(current) == '-') {
            sign = -1;
            current++;
        } else if (current < n && s.charAt(current) == '+') {
            current++;
        }
        while (current < n && Character.isDigit(s.charAt(current))) {
            int digit = s.charAt(current) - '0';
            // check overflow
            // if positive: ans * 10 + digit <= 2147483647
            // if negative: ans * 10 + digit <= 2147483648
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && digit > 7)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = ans * 10 + digit;
            current++;
        }
        return ans * sign;
    }

    public static void main(String[] args) {
        P8 obj = new P8();
        System.out.println("Expect: 42. Received: " + obj.myAtoi("42"));
        System.out.println("Expect: -42. Received: " + obj.myAtoi("   -42"));
        System.out.println("Expect: 4193. Received: " + obj.myAtoi("4193 with words"));
        System.out.println("Expect: 2147483647. Received: " + obj.myAtoi("+2147483649 with words"));
        System.out.println("Expect: -2147483648. Received: " + obj.myAtoi("  -2147483649 with words"));
        System.out.println("Expect: 0. Received: " + obj.myAtoi("+j2147483649 with words"));
    }
}

/**
 * reference
 * https://leetcode.com/problems/string-to-integer-atoi/solution/
 */