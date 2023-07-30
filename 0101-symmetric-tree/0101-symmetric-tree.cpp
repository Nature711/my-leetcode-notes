/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (root == nullptr) return true;
        return isSymmetricHelper(root->left, root->right);
    }
    
    bool isSymmetricHelper(TreeNode* leftTree, TreeNode* rightTree) {
        if (leftTree == nullptr && rightTree == nullptr) return true;
        if ((leftTree == nullptr && rightTree != nullptr) || 
            (rightTree == nullptr && leftTree != nullptr)) return false;
        
        return leftTree->val == rightTree->val && 
            isSymmetricHelper(leftTree->right, rightTree->left) &&
            isSymmetricHelper(leftTree->left, rightTree->right);
    }
};