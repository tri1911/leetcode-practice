package programmingSkills1;

/**
 * Date: March 15, 2022
 * 1491. Average Salary Excluding the Minimum and Maximum Salary
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 */

public class P1491 {
    // time: O(n)
    // space: O(1)
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
