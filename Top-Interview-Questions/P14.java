package topInterviewQs;

// Date: Jan 9, 2022
// 14. Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/

// TODO: check out official solution
// https://leetcode.com/problems/longest-common-prefix/solution/

public class P14 {
    // time complexity: O(l * n) where l is the min string len and n is the number of strings
    // space complexity: O(1)
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        int minLen = strs[0].length();
        while (i < minLen) {
            boolean isMatched = true;
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].isEmpty()) return ""; // edge case
                if (i == 0) minLen = Math.min(strs[j].length(), minLen);
                if (strs[j].charAt(i) != ch) {
                    isMatched = false;
                    break;
                }
            }
            if (isMatched)
                ans.append(ch);
            else
                break;
            i++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        P14 obj = new P14();
        System.out.println("Expected: fl. Received: " + obj.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("---");
        System.out.println("Expected: . Received: " + obj.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}

/*
    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"
    Example 2:

    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
 */
