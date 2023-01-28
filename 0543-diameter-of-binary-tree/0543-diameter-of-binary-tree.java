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
    
    int globalMax = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepthFromNode(root);
        return globalMax; 
    }
    
    public int maxDepthFromNode(TreeNode root) {
        if (root == null) return 0;
        
        int maxFromLeft = maxDepthFromNode(root.left);
        int maxFromRight = maxDepthFromNode(root.right);
        
        globalMax = Math.max(globalMax, maxFromLeft + maxFromRight);
        
        return 1 + Math.max(maxFromLeft, maxFromRight);
    }

}