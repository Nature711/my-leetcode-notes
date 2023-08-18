/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if (node == nullptr) return nullptr;
        unordered_set<int> visited;
        unordered_map<int, Node*> clonedNodes;
        stack<Node*> stack;
        Node* n = new Node(node->val);
        visited.insert(node->val);
        clonedNodes[node->val] = n;
        stack.push(node);
        
        while (!stack.empty()) {
            Node* oldCurr = stack.top();
            stack.pop();
            Node* clonedCurr = clonedNodes[oldCurr->val]; //must have already exists in map
            
            for (Node* neighbor: oldCurr->neighbors) {
                if (clonedNodes.find(neighbor->val) == clonedNodes.end()) {
                    clonedNodes[neighbor->val] = new Node(neighbor->val);
                } 
                
                Node* clonedNeighbor = clonedNodes[neighbor->val];
                clonedCurr->neighbors.emplace_back(clonedNeighbor);
                
                if (visited.find(neighbor->val) == visited.end()) {
                    stack.push(neighbor);
                    visited.insert(neighbor->val);
                } 
            }
        }
      
        return clonedNodes[node->val];
    }

};