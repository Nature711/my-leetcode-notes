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
    
    int globalMaxLength = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return globalMaxLength;
    }
    
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int leftPath = 0;
        int rightPath = 0;
        
        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        
        if (root.left != null && root.val == root.left.val) {
            leftPath = leftLen + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightPath = rightLen + 1;
        }
        
        globalMaxLength = Math.max(globalMaxLength, leftPath + rightPath);
        
        return Math.max(leftPath, rightPath);
    }
}