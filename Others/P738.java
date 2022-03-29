package others;

/**
 * Date: March 29, 2022
 * 738. Monotone Increasing Digits
 * https://leetcode.com/problems/monotone-increasing-digits/
 */

// TODO: check out better approach

public class P738 {
    // time: O(log(n))
    // space: O(log(n))
    public int monotoneIncreasingDigits(int n) {
        // from the left to right, find the first digit that is strictly greater than the next digit
        char[] arr = Integer.toString(n).toCharArray();
        int idx = 0, i = 1, len = arr.length;
        // takes O(log(n))
        for (; i < len; i++) {
            if (arr[i] == arr[i - 1]) continue;
            if (arr[i] < arr[i - 1]) break;
            else idx = i;
        }
        // if all digits are satisfied the condition, then return n itself
        if (i == len) return n;
        // find the solution - takes O(log(n))
        int ans = 0;
        for (int j = 0; j < len; j++) {
            int val = arr[j] - '0';
            ans = ans * 10 + val;
            if (j == idx) {
                ans = ans * (int) Math.pow(10, len - 1 - idx) - 1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P738 obj = new P738();
        System.out.println("Expected: 9. Received: " + obj.monotoneIncreasingDigits(10));
        System.out.println("Expected: 1234. Received: " + obj.monotoneIncreasingDigits(1234));
        System.out.println("Expected: 299. Received: " + obj.monotoneIncreasingDigits(332));
        System.out.println("Expected: 119. Received: " + obj.monotoneIncreasingDigits(120));
        System.out.println("Expected: 2299. Received: " + obj.monotoneIncreasingDigits(2331));
        System.out.println("Expected: 11. Received: " + obj.monotoneIncreasingDigits(11));
    }
}
