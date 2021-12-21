// Date: Sun, Oct 3, 2021
// 83. Remove Duplicates from Sorted List (https://leetcode.com/problems/remove-duplicates-from-sorted-list/)

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

// Using hash table (can use for unsorted linked list)
// time complexity: O(n)
// space complexity: O(n)
ListNode* deleteDuplicates(ListNode* head) {
	unordered_set<int> s;
	ListNode* cur = head;
	ListNode* prev = nullptr;
	while (cur) {
		if (!s.insert(cur->val).second)
			prev->next = cur->next;
		else
			prev = cur;
		cur = cur->next;
	}
	return head;
}

// better solution
// time complexity: O(n)
// space complexity: O(1)
ListNode* deleteDuplicates(ListNode* head) {
	if (!head) return nullptr;
	ListNode* prev = head;
	ListNode* cur = head->next;
	while (cur) {
		if (cur->val == prev->val)
			prev->next = cur->next;
		else
			prev = cur;
		cur = cur->next;
	}
	return head;
}