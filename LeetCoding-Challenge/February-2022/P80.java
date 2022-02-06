package leetcodingchallenge.february2022;

/**
 * Date: Feb 6, 2022
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */

// TODO: review the optimized solution

public class P80 {
    // optimized the first attempt
    // time: O(n)
    // space: O(1)
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int num : nums)
            if (k < 2 || num > nums[k - 2])
                nums[k++] = num;
        return k;
    }

    /*  my first attempt
        public int removeDuplicates(int[] nums) {
            int count = 1, k = 1;
            for (int i = 1; i < nums.length; i++) {
                count = nums[i] == nums[k - 1] ? count + 1 : 1;
                if (count <= 2) {
                    swap(nums, i, k++); // actually we don't need to swap, just assign
                }
            }
            return k;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
     */

    public static void main(String[] args) {
        P80 obj = new P80();
        System.out.println(("Expected: 5. Received: " + obj.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3})));
        System.out.println(("Expected: 7. Received: " + obj.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3})));
    }
}

/**
 * reference
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/discuss/27976/3-6-easy-lines-C%2B%2B-Java-Python-Ruby
 */