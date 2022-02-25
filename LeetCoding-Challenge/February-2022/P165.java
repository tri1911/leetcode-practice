package leetcodingchallenge.february2022;

/**
 * Date: Feb 25, 2022
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/
 */

public class P165 {
    // own solution
    // time: O(m + n)
    // space: O(m + n) or O(1)
    public int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();
        int p1 = 0, p2 = 0;
        while (p1 < v1.length || p2 < v2.length) {
            int num1 = 0;
            while (p1 < v1.length && v1[p1++] != '.') num1 = num1 * 10 + (v1[p1 - 1] - '0');
            int num2 = 0;
            while (p2 < v2.length && v2[p2++] != '.') num2 = num2 * 10 + (v2[p2 - 1] - '0');
            if (num1 != num2) return num1 > num2 ? 1 : -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        P165 obj = new P165();
        System.out.println("Expected: 0. Received: " + obj.compareVersion("1.01", "1.001"));
        System.out.println("Expected: 0. Received: " + obj.compareVersion("1.0", "1.0.0"));
        System.out.println("Expected: -1. Received: " + obj.compareVersion("0.1", "1.1"));
        System.out.println("Expected: -1. Received: " + obj.compareVersion("1", "1.1"));
    }
}
