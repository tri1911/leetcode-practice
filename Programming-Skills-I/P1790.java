package programmingSkills1;

/**
 * Date: March 19, 2022
 * 1790. Check if One String Swap Can Make Strings Equal
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 */

public class P1790 {
    // time: O(n)
    // space: O(1)
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[][] swapChars = new char[2][2];
        int difCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            if (ch1 != ch2) {
                if (difCount > 1) return false;
                swapChars[0][difCount] = ch1;
                swapChars[1][difCount] = ch2;
                difCount++;
            }
        }
        return (difCount == 0) || (swapChars[0][0] == swapChars[1][1] && swapChars[0][1] == swapChars[1][0]);
    }

    public static void main(String[] args) {
        P1790 obj = new P1790();
        System.out.println("Expected: true. Received: " + obj.areAlmostEqual("bank", "kanb"));
        System.out.println("Expected: false. Received: " + obj.areAlmostEqual("attack", "defend"));
        System.out.println("Expected: true. Received: " + obj.areAlmostEqual("kelb", "kelb"));
    }
}
