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
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        ListNode* ptr = head;
        int count = 0;
        while (ptr != nullptr) {
            ptr = ptr->next;
            count++;
        }
        int num_bigger = count % k, num_smaller = k - num_bigger, size_smaller = count / k, size_bigger = size_smaller + 1;
        ptr = head;
        vector<ListNode*> res;
        for (int i = 0; i < k; i++) {
            ListNode* curr_head = ptr;
            int size = (i < num_bigger ? size_bigger : size_smaller);
            for (int j = 0; j < size - 1; j++) {
                ptr = ptr->next;
            }
            ListNode* tmp_next_head = ptr == nullptr ? nullptr : ptr->next;
            if (ptr != nullptr) ptr->next = nullptr;
            res.push_back(curr_head);
            ptr = tmp_next_head;
        }
        return res;
    }
};