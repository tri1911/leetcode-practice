package programmingSkills1;

/**
 * Date: March 15, 2022
 * 1523. Count Odd Numbers in an Interval Range
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 */

public class P1523 {
    // time & space: O(1)
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        double sum = 0;
        for (int val : salary) {
            min = Math.min(min, val);
            max = Math.max(max, val);
            sum += val;
        }
        return (sum - max - min) / (salary.length - 2);
    }
}
