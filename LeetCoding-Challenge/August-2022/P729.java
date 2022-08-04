package leetcodingchallenge.august2022;

import java.util.TreeMap;

/**
 * Date: August 03, 2022
 * 729. My Calendar I
 * https://leetcode.com/problems/my-calendar-i/
 */

// TODO: learn more about `TreeMap`

// time: O(n*log(n))
// space: O(n)
public class P729 {
    private TreeMap<Integer, Integer> calendar;

    public P729() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * reference
 * https://leetcode.com/problems/my-calendar-i/solution/
 */