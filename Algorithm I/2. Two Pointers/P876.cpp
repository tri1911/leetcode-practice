// Date: Mon, Sep 27, 2021
// 876. Middle of the Linked List (https://leetcode.com/problems/middle-of-the-linked-list/)

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
	// my solution
	// time complexity: O(n)
	// space complexity: O(1)
    // ListNode* middleNode(ListNode* head) {
    //     int count = 0;
    //     ListNode* current = head;
    //     // takes O(n) time
    //     while (current) {
    //     	count++;
    //     	current = current->next;
    //     }
    //     current = head;
    //     count = count / 2;
    //     // takes O(n) time
    //     for (int i = 0; i < count; i++)
    //     	current = current->next;
    //     return current;
    // }

    // so great leetcode solution!
    // two-pointer approach
    ListNode* middleNode(ListNode* head) {
    	ListNode* slow = head;
    	ListNode* fast = head;
    	while (fast && fast->next) {
    		fast = fast->next->next;
    		slow = slow->next;
    	}
    	return slow;
    }
};