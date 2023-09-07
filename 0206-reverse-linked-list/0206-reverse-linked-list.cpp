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
    
    int getNodeCount(ListNode* head) {
        int res = 0;
        while (head != nullptr) {
            head = head->next;
            res++;
        }
        return res;
    }
    
    ListNode* reverseList(ListNode* head) {
        // Handle the edge case of an empty list
        if (!head) return nullptr;

        // Create a dummy node to handle the case when left = 1
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* prev = dummy;
        
        // Start reversing the sublist
        ListNode* current = prev->next;
        ListNode* next = nullptr;
        
        int n = getNodeCount(head);

        for (int i = 0; i < n - 1; i++) {
            next = current->next;
            current->next = next->next;
            next->next = prev->next;
            prev->next = next;
        }

        return dummy->next;
    }
    

};

