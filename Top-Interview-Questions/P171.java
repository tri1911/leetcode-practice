package topInterviewQs;

/**
 * Date: Jan 10, 2022
 * 171. Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/
 */

public class P171 {
    // time complexity: O(n)
    // space complexity: O(1)
    public int titleToNumber(String columnTitle) {
        /*  First Attempt
            // 26-based numbers
            int answer = 0, factor = 1;
            for (int i = columnTitle.length() - 1; i >= 0; i--) {
                answer += (columnTitle.charAt(i) - 'A' + 1) * factor;
                factor *= 26;
            }
            return answer;
         */
        // Redo on Feb 21, 2022
        int ans = 0;
        for (char ch : columnTitle.toCharArray())
            ans = ans * 26 + (ch - 'A' + 1);
        return ans;
    }

    public static void main(String[] args) {
        P171 obj = new P171();
        System.out.println("Expected: 1. Received: " + obj.titleToNumber("A"));
        System.out.println("----");
        System.out.println("Expected: 28. Received: " + obj.titleToNumber("AB"));
        System.out.println("----");
        System.out.println("Expected: 701. Received: " + obj.titleToNumber("ZY"));
    }
}
