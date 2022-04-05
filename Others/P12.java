package others;

/**
 * Date: April 04, 2022
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/
 */

public class P12 {
    // my own approach
    // time: O(1)
    // space: O(1)
    public String intToRoman(int num) {
        String[][] dict = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        StringBuilder sb = new StringBuilder();
        int i = 3, j;
        while (i >= 0) {
            int base = (int) Math.pow(10, i);
            j = (num / base) % 10;
            sb.append(dict[i--][j]);
        }
        return sb.toString();
    }
}
