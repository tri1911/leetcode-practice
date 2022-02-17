package others;

/**
 * Date: Feb 17, 2022
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 */

// TODO: review the solution

public class P367 {
    // use binary search
    // time: O(log(n))
    // space: O(1)
    public boolean isPerfectSquare(int num) {
        long low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val == num) return true;
            else if (val > num) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        P367 obj = new P367();
        System.out.println("Expected: true. Received: " + obj.isPerfectSquare(16)); // a * a = n =>
        System.out.println("Expected: false. Received: " + obj.isPerfectSquare(14));
    }
}

/**
 * reference
 * https://leetcode.com/problems/valid-perfect-square/discuss/83874/A-square-number-is-1%2B3%2B5%2B7%2B...-JAVA-code
 */