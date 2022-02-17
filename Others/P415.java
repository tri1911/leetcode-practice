package others;

/**
 * Date: Feb 17, 2022
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/
 */

public class P415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) return addStrings(num2, num1);
        int len1 = num1.length(), len2 = num2.length();
        String ans = "";
        int carry = 0;
        for (int i = len1 - 1, j = len2 - 1; j >= 0; i--, j--) {
            int val1 = num1.charAt(i) - '0';
            int val2 = num2.charAt(j) - '0';
            int sum = val1 + val2 + carry;
            carry = sum > 9 ? 1 : 0;
            ans = (sum % 10) + ans;
        }
        int i = len1 - len2 - 1;
        while (carry == 1) {
            int sum = 0;
            if (i >= 0) {
                sum = num1.charAt(i) - '0' + carry;
            } else {
                ans = "1" + ans;
                break;
            }
            carry = sum > 9 ? 1 : 0;
            ans = (sum % 10) + ans;
            i--;
        }
        return i >= 0 ? num1.substring(0, i + 1) + ans : ans;
    }
}

/**
 * reference
 */