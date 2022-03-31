package others;

/**
 * Date: March 30, 2022
 * 706. Design HashMap
 * https://leetcode.com/problems/design-hashmap/
 */

// TODO: implement with collision resolver (chaining, linked-list ...)

public class P706 {
    private final int[] map;

    public P706() {
        map = new int[1_000_001];
        for (int i = 0; i < map.length; i++) map[i] = -1;
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
