package leetcodingchallenge.march2022;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: March 14, 2022
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/
 */

public class P71 {
    // time: O(n) where n is the number of directory/file names
    // space: O(n)
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : path.split("/")) {
            if (token.equals("..")) stack.poll();
            else if (!(token.isEmpty() || token.equals("."))) stack.push(token);
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append("/").append(stack.pollLast());
        return sb.toString();
    }

    public static void main(String[] args) {
        P71 obj = new P71();
        System.out.println("Expected: /c. Received: " + obj.simplifyPath("/a/./b/../../c/"));
    }
}

/**
 * reference
 * https://leetcode.com/problems/simplify-path/discuss/25778/Java-easy-to-understand-Stack-solution.
 * https://leetcode.com/problems/simplify-path/discuss/1050559/Java-easy-to-read-easy-to-understand
 */