package programmingSkills1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Date: March 19, 2022
 * 1502. Can Make Arithmetic Progression From Sequence
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 */

public class P1502 {
    // time: O(n*log(n))
    // space: O(1)
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int target = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) if (arr[i] - arr[i - 1] != target) return false;
        return true;
    }

    // another linear approach
    // time: O(n)
    // space: O(n)
    public boolean _canMakeArithmeticProgression(int[] arr) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            set.add(num);
        }
        if ((max - min) % (arr.length - 1) != 0) return false;
        int dif = (max - min) / (arr.length - 1);
        for (int i = 0; i < arr.length; i++)
            if (!set.contains(min + i * dif)) return false;
        return true;
    }
}
