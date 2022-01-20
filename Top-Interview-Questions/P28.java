package topInterviewQs;

// Date: Jan 9, 2022
// 28. Implement strStr()
// https://leetcode.com/problems/implement-strstr/

// TODO: take a look about string search algorithm if have time
// https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_string-search_algorithm
// https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
// http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/

// TODO: learn about Rabin-Karp or KMP algorithms
// https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/

public class P28 {
    // naive search
    // time complexity: O(n *(m-n+1))
    // space complexity: O(1)
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n == 0) return 0;
        for (int i = 0; i <= m - n; i++) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.charAt(i + n - 1) == needle.charAt(n - 1)) {
                for (int j = 0; j < n; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                    if (j == n - 1) return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        P28 obj = new P28();
        System.out.println("Expected: 0. Received: " + obj.strStr("a", "a"));
        System.out.println("Expected: 2. Received: " + obj.strStr("hello", "ll"));
        System.out.println("Expected: -1. Received: " + obj.strStr("aaaaa", "bba"));
        System.out.println("Expected: 0. Received: " + obj.strStr("", ""));
    }
}

// reference
// https://www.geeksforgeeks.org/naive-algorithm-for-pattern-searching/
// https://leetcode.com/problems/implement-strstr/discuss/13160/detailed-explanation-on-building-up-lps-for-kmp-algorithm
// https://stackoverflow.com/questions/12752274/java-indexofstring-str-method-complexity/12752295
// https://softwareengineering.stackexchange.com/questions/65558/why-does-javas-string-class-not-implement-a-more-efficient-indexof