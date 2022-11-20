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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, Long.MIN_VALUE, root.val) && helper(root.right, root.val, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode node, long low, long high) {
        if (node == null) return true;
        
        if (node.val <= low || node.val >= high) return false;
        
        return helper(node.left, low, node.val) && helper(node.right, node.val, high);
    }
    
}