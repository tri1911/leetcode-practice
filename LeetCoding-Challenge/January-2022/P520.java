package leetcodingchallenge.january2022;

/**
 * Date: Jan 24, 2022
 * 520. Detect Capital
 * https://leetcode.com/problems/detect-capital/
 */

// TODO: if have time, read "Regex" approach in the official solution

public class P520 {
    // time: O(n)
    // space: O(1)
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        // edge case
        if (n == 1) return true;
        // case 1: all letters are uppercase
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < n; i++) {
                if (Character.isLowerCase(word.charAt(i))) return false;
            }
        } else { // case 2, 3: the rest are lowercase letters
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P520 obj = new P520();
        System.out.println("Expected: true. Received: " + obj.detectCapitalUse("USA"));
        System.out.println("Expected: false. Received: " + obj.detectCapitalUse("FlaG"));
    }
}

/**
 * reference:
 * https://leetcode.com/problems/detect-capital/solution/
 */