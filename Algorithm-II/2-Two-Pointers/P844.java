package algorithm2.twoPointers;

/**
 * Date: Dec 14, 2021 - Redo: May 01, 2022
 * 844. Backspace String Compare
 * https://leetcode.com/problems/backspace-string-compare/
 */

public class P844 {
    // time complexity: O(m + n)
    // space complexity: O(1)
    public static boolean backspaceCompare(String s, String t) {
        int p1 = s.length() - 1, p2 = t.length() - 1;
        int count1 = 0, count2 = 0;
        while (p1 >= 0 || p2 >= 0) {
            // find the actual character in s
            while (p1 >= 0) {
                if (s.charAt(p1) == '#') { count1++; p1--; }
                else if (count1 > 0) { count1--; p1--; }
                else break;
            }
            // find the actual character in t
            while (p2 >= 0) {
                if (t.charAt(p2) == '#') { count2++; p2--; }
                else if (count2 > 0) { count2--; p2--; }
                else break;
            }
            // compare 2 current character in strings s and t
            if (p1 >= 0 && p2 >= 0 && s.charAt(p1) != s.charAt(p2))  return false;
            if ((p1 >= 0) != (p2 >= 0)) return false;
            p1--; p2--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Expect: true. Received: " + backspaceCompare("ab#c", "ad#c"));
        System.out.println("Expect: true. Received: " + backspaceCompare("ab##", "c#d#"));
        System.out.println("Expect: true. Received: " + backspaceCompare("a##c", "#a#c"));
        System.out.println("Expect: false. Received: " + backspaceCompare("a#c", "b"));
    }
}

/**
 * references
 * https://leetcode.com/problems/backspace-string-compare/solution/
 */