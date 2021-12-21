package algorithm2.slidingWindow;

import java.util.*;

// date: Dec 14, 2021
// 438. Find All Anagrams in a String
// https://leetcode.com/problems/find-all-anagrams-in-a-string/

// time complexity: O(n)
// space complexity: O(1)
public class P438 {
    // First attempt
//    public static List<Integer> findAnagrams(String s, String p) {
//        int n = s.length(), m = p.length();
//        List<Integer> ans = new LinkedList<>();
//        double[] letters = new double[26];
//        for (int i = 0; i < 26; i++) {
//            letters[i] = Math.pow(26, i);
//        }
//        double a = 0;
//        for (char ch : p.toCharArray()) {
//            a += letters[ch - 'a'];
//        }
//        double b = 0;
//        for (int i = 0; i < m; i++) {
//            b += letters[s.charAt(i) - 'a'];
//        }
//        if (b == a) ans.add(0);
//        for (int i = m; i < n; i++) {
//            // main problem is: how to compare two anagrams in constant time
//            b -= letters[s.charAt(i - m) - 'a'];
//            b += letters[s.charAt(i) - 'a'];
//            if (b == a) ans.add(i - m + 1);
//        }
//        return ans;
//    }

    // Second attempt using HashMap
//    public static List<Integer> findAnagrams(String s, String p) {
//        int m = s.length(), n = p.length();
//        List<Integer> ans = new ArrayList<>();
//        if (m < n) return ans;
//        Map<Character, Integer> sCounters = new HashMap<>();
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            sCounters.put(ch, 0);
//        }
//        Map<Character, Integer> pCounters = new HashMap<>(sCounters);
//        for (char ch : p.toCharArray()) {
//            pCounters.replace(ch, pCounters.get(ch) + 1);
//        }
//        for (int i = 0; i < n; i++) {
//            char ch = s.charAt(i);
//            sCounters.replace(ch, sCounters.get(ch) + 1);
//        }
//        if (sCounters.equals(pCounters)) ans.add(0);
//        for (int i = n; i < m; i++) {
//            sCounters.replace(s.charAt(i - n), sCounters.get(s.charAt(i - n)) - 1);
//            sCounters.replace(s.charAt(i), sCounters.get(s.charAt(i)) + 1);
//            if (sCounters.equals(pCounters)) ans.add(i - n + 1);
//        }
//        return ans;
//    }

    // optimized solution (reference from Nick's video)
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> ans = new ArrayList<>();
        if (sLen < pLen) return ans;
        int[] counters = new int[26];
        for (char ch : p.toCharArray()) {
            counters[ch - 'a']++;
        }
        int left = 0, right = 0;
        int target = pLen;
        while (right < sLen) {
            int index = s.charAt(right) - 'a';
            if (counters[index] >= 1) {
                target--;
            }
            counters[index]--;
            right++;

            if (target == 0) {
                ans.add(left);
            }

            if (right - left == pLen) {
                index = s.charAt(left) - 'a';
                if (counters[index] >= 0) {
                    target++;
                }
                counters[index]++;
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Expect: [0, 6]. Output: " + findAnagrams("cbaebabacd", "abc"));
        System.out.println("Expect: [0, 1, 2]. Output: " + findAnagrams("abab", "ab"));
        System.out.println("Expect: []. Output: " + findAnagrams("aacbebabacd", "bbb"));
        System.out.println("Expect: [2]. Output: " + findAnagrams("bpaa", "aa"));
        System.out.println("Expect: []. Output: " + findAnagrams("afdkljflsdkjfsdlkjfdslkjfdslkjfkljlkjlkfdjslkfjsdlkjsdflksdjflkdsjfldskjksldfjlksdjflkdsjfsjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjfsdfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "z"));
    }
}

// reference
// https://www.youtube.com/watch?v=fvEw13A5O1o

// TODO: Check out another optimized solution and analyze time complexity
// https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
// Useful to know apis: map.getOrDefault(c, 0)