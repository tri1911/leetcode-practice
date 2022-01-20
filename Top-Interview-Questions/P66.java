package topInterviewQs;

import java.util.Arrays;

/**
 * Date: Jan 12, 2022
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 */

public class P66 {
    // optimized solution
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // if reach here, then the answer will have n + 1 digits e.g. 99 -> 100
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    /*  First attempt - time & space O(n)
        List<Integer> answer = new ArrayList<>();
        int n = digits.length, carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (i == n - 1)
                sum += 1;
            answer.add(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) answer.add(1);
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++)
            result[answer.size() - 1 - i] = answer.get(i);
        return result;
     */

    /*  Second attempt - space O(n) still
        int val = 0;
        for (int digit : digits)
            val = val * 10 + digit;
        val++;
        int size = String.valueOf(val).length();
        int[] answer = new int[size];
        int i = size - 1;
        while (val != 0) {
            answer[i--] = val % 10;
            val /= 10;
        }
        return answer;
     */

    public static void main(String[] args) {
        P66 obj = new P66();
        int[] digits = {1, 9, 9};
        System.out.println(Arrays.toString(obj.plusOne(digits)));
    }
}

/**
 * reference
 * https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution
 */