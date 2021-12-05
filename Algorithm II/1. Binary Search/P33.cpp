// Date: Sun, Nov 21, 2021
// 33. Search in Rotated Sorted Array

class Solution {
public:
	// there are 4 possible scenarios when performing binary search
	// target > nums[mid]
	// 		mid is in the large part
	//		mid is in the small part
	// target < nums[mid]
	// 		mid is in the large part
	//		mid is in the small part
    int search(vector<int>& nums, int target) {
    	int n = nums.size();
        int first = nums[0];
        int low = 0, high = n - 1;
        while (left <= high) {
        	int mid = (low + high) / 2;
        	int value = nums[mid];
        	// if found, return the index
        	if (value == target)
        		return mid;
        	if (target > value) {
        		if ()
        	}
        }
    }
};