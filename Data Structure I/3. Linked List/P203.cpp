// Date: Sat, Oct 3, 2021
// 203. Remove Linked List Elements

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

// iterative approach
// time complexity: O(n) (faster than 96.87%)
// space complexity: O(1) (less than 42.84%)
ListNode* removeElements(ListNode* head, int val) {
	if (!head) 
		return head;
	ListNode* prev = NULL;
	ListNode* current = head;
	while (current) {
		if (current->val == val)
			if (prev)
				prev->next = current->next;
			else
				head = head->next;
		else
			prev = current;
		current = current->next;
	}
	return head;
}

// recursion approach
ListNode* removeElements(ListNode* head, int val) {
	if (!head)
		return nullptr;
	if (head->val == val) {
		return removeElements(head->next, val);
	}
	head->next = removeElements(head->next, val);
	return head;
}