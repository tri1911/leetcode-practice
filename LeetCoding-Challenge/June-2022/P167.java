package leetcodingchallenge.june2022;

/**
 * Date: June 09, 2022
 * 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

public class P167 {
    // time: O(n)
    // space: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1, sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum > target) right--;
            else if (sum < target) left++;
            else break;
        }
        return new int[]{left + 1, right + 1};
    }
}
