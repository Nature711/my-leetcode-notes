/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    Stack<TreeNode> stack = new Stack<>();
    
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        
        int acc = 0;
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            acc +=  currNode.val;
            currNode.val = acc;
        }
        
        return root;
    }
    
    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        stack.push(node);
        inorder(node.right);
    }
    
    
    
    
}



