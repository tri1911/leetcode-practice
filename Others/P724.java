package others;

/**
 * Date: March 12, 2022
 * 724. Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/
 */

public class P724 {
    // time: O(n)
    // space: O(1)
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            left += i > 0 ? nums[i - 1] : 0;
            if (left == sum - left - nums[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        P724 obj = new P724();
        System.out.println("Expected: 3. Received: " + obj.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
