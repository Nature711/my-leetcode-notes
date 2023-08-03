/*
// Definition for a QuadTree node.
class Node {
public:
    bool val;
    bool isLeaf;
    Node* topLeft;
    Node* topRight;
    Node* bottomLeft;
    Node* bottomRight;
    
    Node() {
        val = false;
        isLeaf = false;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }
    
    Node(bool _val, bool _isLeaf, Node* _topLeft, Node* _topRight, Node* _bottomLeft, Node* _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

class Solution {
public:
    Node* construct(vector<vector<int>>& grid) {
        return helper(grid, 0, 0, grid.size());
    }
    
    Node* helper(vector<vector<int>>& grid, int R, int C, int len) {
        if (len == 1) {
            Node* n = new Node(grid[R][C], 1);
            return n;
        }
        
        int half = len / 2;
     
        Node* topLeft = helper(grid, R, C, half);
        Node* topRight = helper(grid, R, C + half, half);
        Node* bottomLeft = helper(grid, R + half, C, half);
        Node* bottomRight = helper(grid, R + half, C + half, half);
        
        if (topLeft->isLeaf && topRight->isLeaf && bottomLeft->isLeaf && bottomRight->isLeaf
            && topLeft->val == topRight->val && topRight->val == bottomLeft->val && bottomLeft->val == bottomRight->val) {
            return new Node(topLeft->val, 1);
        } else {
            return new Node(1, 0, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
    
};