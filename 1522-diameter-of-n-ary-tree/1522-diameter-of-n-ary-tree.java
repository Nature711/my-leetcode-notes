/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int maxDiameter = 0;
    public int diameter(Node root) {
        maxDepth(root);
        return maxDiameter;
    }
    
    public int maxDepth(Node root) {
        if (root == null) return -1;
        
        int maxDepth = 0;
        int max = -1, secondMax = -1;
        for (Node child: root.children) {
            int depth = maxDepth(child);
            if (depth > max) {
                secondMax = max;
                max = depth;
            } else if (depth > secondMax) secondMax = depth;
        }
        maxDiameter = Math.max(maxDiameter, max + secondMax + 2);
        return 1 + max;
    }
}