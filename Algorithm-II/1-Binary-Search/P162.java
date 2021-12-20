package algorithm2.binarySearch;

// date: Dec 20, 2021
// 162. Find Peak Element
// https://leetcode.com/problems/find-peak-element/

public class P162 {
    // linear solution
    // time complexity: O(n)
    // space complexity: O(1)
    public int _findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }
        return nums.length - 1;
    }

    // Iterative binary search
    // time complexity: O(log(n))
    // space complexity: O(1)
    public int findPeakElement_2(int[] nums) {
        int low = 0, high = nums.length - 1, mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}

// reference
// https://leetcode.com/problems/find-peak-element/solution/