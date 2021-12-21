// Date: Thu, Sep 30, 2021
// 21. Merge Two Sorted Lists (https://leetcode.com/problems/merge-two-sorted-lists/)

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
	// recursion approach
	// time complexity: O(m+n) where m,n is the length of 2 lists
	// space complexity: O(1)
	// failed test case: [5] [1,2,4]
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
	    if (!l1 || !l2)
            return l1 ? l1 : l2;
        if (l1->val == l2->val) {
            ListNode* result = mergeTwoLists(l1->next, l2->next);
            l1->next = l2;
            l2->next = result;
            return l1;
        }
        if (l1->val < l2->val) {
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        }
        l2->next = mergeTwoLists(l1, l2->next);
        return l2;
	}
};