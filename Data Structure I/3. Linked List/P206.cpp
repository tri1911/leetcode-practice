// Date: Sun, Oct 3, 2021
// 206. Reverse Linked List (https://leetcode.com/problems/reverse-linked-list/)
// Redo

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

// recursive approach
ListNode* dfs(ListNode* prev, ListNode* cur) {
	if (!cur) return prev;
	ListNode* next = cur->next;
	cur->next = prev;
	return dfs(cur, next);
}

ListNode* reverseList(ListNode* head) {
	if (!head) return head;
	return dfs(nullptr, head);
}
