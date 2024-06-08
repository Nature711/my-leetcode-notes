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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDiameter;   
    }
    
    public int helper(TreeNode root) {
        if (root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        int res = 0;
        if (root.left != null) res = Math.max(res, 1 + left);
        if (root.right != null) res = Math.max(res, 1 + right);
        int diaViaRoot = 0;
        if (root.left != null) diaViaRoot += left + 1;
        if (root.right != null) diaViaRoot += right + 1;
        maxDiameter = Math.max(maxDiameter, diaViaRoot);
        return res;
    }
}