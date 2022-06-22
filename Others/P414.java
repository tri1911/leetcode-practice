package others;

/**
 * Date: June 22, 2022
 * 414. Third Maximum Number
 * https://leetcode.com/problems/third-maximum-number/
 */

public class P414 {
    // time: O(n)
    // space: O(1)
    public int thirdMax(int[] nums) {
        Integer[] set = new Integer[3]; // set[0] > set[1] > set[2]
        for (Integer num : nums) {
            if (!num.equals(set[0]) && !num.equals(set[1]) && !num.equals(set[2])) {
                if (set[0] == null || num > set[0]) {
                    set[2] = set[1];
                    set[1] = set[0];
                    set[0] = num;
                } else if (set[1] == null || num > set[1]) {
                    set[2] = set[1];
                    set[1] = num;
                } else if (set[2] == null || num > set[2]) {
                    set[2] = num;
                }
            }
        }
        return set[2] == null ? set[0] : set[2];
    }
}

/**
 * references
 * https://leetcode.com/problems/third-maximum-number/discuss/90202/Java-neat-and-easy-understand-solution-O(n)-time-O(1)-space
 */