package others;

import java.util.Arrays;

/**
 * Date: March 30, 2022 - Redo: April 21, 2022
 * 706. Design HashMap
 * https://leetcode.com/problems/design-hashmap/
 */

// TODO: implement with collision resolver (chaining, linked-list ...)

public class P706 {
    private int[] map;

    public P706() {
        map = new int[1_000_001];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}
