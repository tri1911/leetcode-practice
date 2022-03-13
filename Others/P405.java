package others;

/**
 * Date: March 12, 2022
 * 405. Convert a Number to Hexadecimal
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */

public class P405 {
    // time: O(n)
    // space: O(1)
    public String toHex(int num) {
        // Observation
        // In Java, negative numbers are stored as 2's complement
        if (num == 0) return "0";
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            // bit manipulation tricks:
            // >>> 4 => / 16
            // using mask: & 1111 (= 15) => % 16
            ans.append(hex[num & 15]);
            num >>>= 4;
        }
        return ans.reverse().toString();
    }
}

/**
 * reference
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/discuss/89253/Simple-Java-solution-with-comment
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
