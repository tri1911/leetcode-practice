package algorithm2.backtracking;

// date: Dec 21, 2021
// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;

public class P17 {
    // time complexity: O(2^n)
    // space complexity: O(n)
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        backtracking(0, digits, map, "", ans);
        return ans;
    }

    private void backtracking(int current, String digits, char[][] map, String s, List<String> ans) {
        if (current == digits.length()) {
            ans.add(s);
            return;
        }
        char[] candidates = map[digits.charAt(current) - '0'];
        for (char ch : candidates) {
            s += ch;
            backtracking(current + 1, digits, map, s, ans);
            s = s.substring(0, s.length() - 1);
        }
    }

    public static void main(String[] args) {
        P17 p = new P17();
        System.out.println("Input: digits = `23`");
        System.out.println("Expect: [ad, ae, af, bd, be, bf, cd, ce, cf]");
        System.out.println("Output: " + p.letterCombinations("23"));
    }
}

// reference
// https://www.baeldung.com/java-remove-last-character-of-string