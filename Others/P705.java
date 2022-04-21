package others;

/**
 * Date: March 30, 2022 - Redo: April 20, 2022
 * 705. Design HashSet
 * https://leetcode.com/problems/design-hashset/
 */

public class P705 {
    private final boolean[] set;

    public P705() {
        set = new boolean[1000_001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}
