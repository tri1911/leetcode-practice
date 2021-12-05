// Date: Sun, Nov 21, 2021
// 34. Find First and Last Position of Element in Sorted Array

class Solution {
public:
	// First try
	// time complexity: O(logn)
	// space complexity: O(1)
    vector<int> searchRange(vector<int>& nums, int target) {
    	vector<int> ans;
        int first = 0, last = nums.size() - 1;
        while (first <= last) {
        	int pivot = (first + last) / 2;
        	if (nums[pivot] == target) {
        		first = last = pivot;
        		while (first >= 0 && nums[first] == target) {
        			first--;
        		}
        		while (last < nums.size() && nums[last] == target) {
        			last++;
        		}
        		ans.push_back(first + 1);
        		ans.push_back(last - 1);
        		return ans;
        	}

        	if (nums[pivot] < target) {
        		first = pivot + 1;
        	} else {
        		last = pivot - 1;
        	}
        }
        return { -1, -1 };
    }
};