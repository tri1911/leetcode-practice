package leetcodingchallenge.march2022;

/**
 * Date: March 22, 2022
 * 1663. Smallest String With A Given Numeric Value
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 */

public class P1663 {
    // first attempt using Greedy Algorithm
    // time: O(n)
    // space: O(1)
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int num = k - 1 > 26 * (n - i) ? (k - 1) % 26 : 0;
            sb.append((char) ('a' + num));
            k -= num + 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P1663 obj = new P1663();
        System.out.println("Expected: aay. Received: " + obj.getSmallestString(3, 27));
        System.out.println("Expected: aaszz. Received: " + obj.getSmallestString(5, 73));
    }
}

/**
 * reference
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/discuss/944538/C%2B%2B-Reverse-Fill
 */