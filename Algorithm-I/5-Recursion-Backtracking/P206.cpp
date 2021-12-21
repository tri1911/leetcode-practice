// Date: Thu, Sep 30, 2021
// 206. Reverse Linked List (https://leetcode.com/problems/reverse-linked-list/)

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
	// time complexity: O(n) where n is the number of nodes
	// space complexity: O(1)
	// ListNode* reverseList(ListNode* previous, ListNode* current) {
	// 	if (current->next == NULL) {
	// 		current->next = previous;
	// 		return current;
	// 	}
	// 	ListNode* next = current->next;
	// 	current->next = previous;
	// 	return reverseList(current, next);
	// }

	// ListNode* reverseList(ListNode* head) {
	// 	if (!head)
	// 		return head;
	// 	return reverseList(NULL, head);
	// }

	// Refactor (Nov 17, 2021)
	ListNode* helper(ListNode* prev, ListNode* cur) {
        if (!cur) return prev;
        ListNode* next = cur->next;
        cur->next = prev;
        return helper(cur, next);
    }
    
    ListNode* reverseList(ListNode* head) {
        return helper(nullptr, head);
    }

	// iterative solution
	// time complexity: O(n)
	// space complexity: O(1)
	ListNode* reverseList(ListNode* head) {
		ListNode *previous = NULL;
	    ListNode *current = head;
	    ListNode *next = NULL;
	    while (current != NULL) {
	        next = current->next; // cache
	        current->next = previous; // update
	        previous = current; // move
	        current = next; // move
	    }
	    return previous;
	}
};