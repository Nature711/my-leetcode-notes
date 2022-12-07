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
        if (root == null) return false;
        return dfs(root, 0, targetSum);
    }
    
    public boolean dfs(TreeNode node, int currSum, int targetSum) {
        currSum += node.val;
        if (node.left == null && node.right == null && currSum == targetSum) return true;
        if (node.left != null && dfs(node.left, currSum, targetSum)) return true;
        if (node.right != null && dfs(node.right, currSum, targetSum)) return true;
        return false;
    }
}

