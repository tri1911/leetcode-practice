package programmingSkills1;

/**
 * Date: March 21, 2022
 * 1678. Goal Parser Interpretation
 * https://leetcode.com/problems/goal-parser-interpretation/
 */

public class P1678 {
    // time: O(n)
    // space: O(1)
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == '(') {
                boolean check = command.charAt(i + 1) == ')';
                sb.append(check ? 'o' : "al");
                i += check ? 2 : 4;
            } else {
                sb.append('G');
                i++;
            }
        }
        return sb.toString();
    }
}
