// Date: Sun, Oct 3, 2021 (Not finished)
// Date: Sun, Nov 14, 2021
// 141. Linked List Cycle (https://leetcode.com/problems/linked-list-cycle/)

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

// Floyd's Hare and Tortoise Algorithm
// Time complexity O(n)
// Space complexity O(1)
bool hasCycle(ListNode *head) {
    if (!head) return head;
    ListNode* slow = head;
    ListNode* fast = head;
    while (fast && fast->next) {
        slow = slow->next;
        fast = fast->next->next;
        if (slow == fast)
            return true;
    }
    return false;
}