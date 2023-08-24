/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        if (root == nullptr) return nullptr;
        Node* leftmost = root;
        while (leftmost->left != nullptr) {
            Node* curr = leftmost;
            while (curr != nullptr) {
                curr->left->next = curr->right;
                curr->right->next = curr->next == nullptr ? nullptr : curr->next->left;
                curr = curr->next;
            }
            leftmost = leftmost->left;
        }
        return root;
    }
};