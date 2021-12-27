package algorithm2.backtracking;

// date: Dec 21, 2021
// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/

// TODO: analyze time complexity
// TODO: check out the solution https://leetcode.com/problems/generate-parentheses/solution/

import java.util.ArrayList;
import java.util.List;

public class P22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(n, n, 0, "", ans);
        return ans;
    }

    private void backtracking(int opens, int closes, int openCount, String s, List<String> ans) {
        if (opens == 0 && closes == 0) {
            ans.add(s);
            return;
        }
        if (opens > 0) {
            s += '(';
            backtracking(opens - 1, closes, openCount + 1, s, ans);
            s = s.substring(0, s.length() - 1);
        }
        if (closes > 0 && openCount > 0) {
            s += ')';
            backtracking(opens, closes - 1, openCount - 1, s, ans);
        }
    }

    public static void main(String[] args) {
        P22 p = new P22();
        System.out.println("Input: n = 3");
        System.out.println("Output: " + p.generateParenthesis(3));
        System.out.println("Expect: [((())), (()()), (())(), ()(()), ()()()]");
        System.out.println("------------------------------------------------");
        System.out.println("Input: n = 1");
        System.out.println("Output: " + p.generateParenthesis(1));
        System.out.println("Expect: [()]");
    }
}
