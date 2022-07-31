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
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
		// condition to end the backtrack
        if(root == null) return false;
		
        //choose
        sum += root.val;   
		
		//explore
        if(root.right == null && root.left == null && sum == targetSum) {
            return true;
        } else {
             if(hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum)) return true;
        }
        //unchoose: 
        sum -= root.val;
        
        return false;        
    }
}

