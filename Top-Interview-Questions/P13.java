package topInterviewQs;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: Jan 13, 2022 - Redo on August 15, 2022
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 */

public class P13 {
    // time: O(n)
    // space: O(n)
    public int _romanToInt(String s) {
        Map<Character, Integer> table = new HashMap<>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        int n = s.length();
        int ans = 0;
        char current, next;
        for (int i = 0; i < n - 1; i++) {
            current = s.charAt(i);
            next = s.charAt(i + 1);
            if (table.get(current) < table.get(next)) ans -= table.get(current);
            else ans += table.get(current);
        }
        return ans + table.get(s.charAt(n - 1));
    }

    // redo on August 15, 2022
    public int romanToInt(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);
        int ans = 0, prev = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = hash.get(s.charAt(i));
            ans += (prev != -1 && cur < prev) ? -cur : cur;
            prev = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        P13 obj = new P13();
        System.out.println("Expected: 3. Received: " + obj.romanToInt("III"));
        System.out.println("Expected: 58. Received: " + obj.romanToInt("LVIII"));
        System.out.println("Expected: 1994. Received: " + obj.romanToInt("MCMXCIV"));
    }
}

/**
 * reference
 * https://leetcode.com/problems/roman-to-integer/discuss/6537/My-Straightforward-Python-Solution
 */
