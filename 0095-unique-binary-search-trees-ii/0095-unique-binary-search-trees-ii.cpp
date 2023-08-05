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
    vector<TreeNode*> generateTrees(int n) {
        return helper(1, n);
    }
    
    vector<TreeNode*> helper(int low, int high) {
        vector<TreeNode*> res;
        if (low > high) {
            res.push_back(nullptr);
            return res;
        }

        for (int i = low; i <= high; i++) {
            vector<TreeNode*> leftTrees = helper(low, i - 1);
            vector<TreeNode*> rightTrees = helper(i + 1, high);
            for (TreeNode* leftTree: leftTrees) {
                for (TreeNode* rightTree: rightTrees) {
                    TreeNode* tree = new TreeNode(i, leftTree, rightTree);
                    res.push_back(tree);
                }
            }
        }
        return res;
    }
};