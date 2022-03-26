package programmingSkills1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Date: March 25, 2022
 * 1356. Sort Integers by The Number of 1 Bits
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 */

public class P1356 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(i -> Integer.bitCount(i) * 10000 + i)).mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        P1356 obj = new P1356();
        System.out.println("Expected: [0, 1, 2, 4, 8, 3, 5, 6, 7]\nReceived: " + Arrays.toString(obj.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println("Expected: [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024]\nReceived: " + Arrays.toString(obj.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
    }
}

/**
 * reference
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/discuss/516985/JavaPython-3-1-liners.
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/discuss/1777390/easy-java-solution-(faster-than-94.95)
 */
