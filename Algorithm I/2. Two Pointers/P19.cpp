// Date: Mon, Sep 27, 2021
// 19. Remove Nth Node From End of List

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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int count = 0;
        ListNode* current = head;
        // takes O(n) time
        while (current) {
            current = current->next;
            count++;
        }
        current = head;
        ListNode* previous = NULL;
        // takes O(n) time
        for(int i = 0; i < count - n; i++) {
            previous = current;
            current = current->next;
        }
        if (current == head) 
            head = head->next;
        else
            previous->next = current->next;
        return head;
    }

    // TODO: interesting two-pointer approach
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
    }
};