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
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxHelper(root);
        return globalMax;
    }
    
    public int maxHelper(TreeNode root) { //sum of the max path we can get involving root
        if (root == null) return 0;
        
        int gainFromLeft = Math.max(maxHelper(root.left), 0);
        int gainFromRight = Math.max(maxHelper(root.right), 0);
        
        globalMax = Math.max(globalMax, root.val + gainFromLeft + gainFromRight);
        
        return root.val + Math.max(gainFromLeft, gainFromRight);
    }
}