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
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
		return backtrack(root, targetSum);  
    }
    
    public boolean backtrack(TreeNode curr, int rem) {
        if (curr == null) return false;
        
        rem -= curr.val;
        
        if (curr.right == null && curr.left == null) {
            if (rem == 0) return true;
            return false;
        }
        
        return backtrack(curr.left, rem) || backtrack(curr.right, rem);
    }
}

