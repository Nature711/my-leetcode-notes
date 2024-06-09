/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        connect(root.left, root.right);
        return root;
    }
    
    void connect(Node leftRoot, Node rightRoot) {
        if (leftRoot == null || rightRoot == null) return;
        
        leftRoot.next = rightRoot;
        connect(leftRoot.left, leftRoot.right);
        connect(leftRoot.right, rightRoot.left);
        connect(rightRoot.left, rightRoot.right);
    }
}