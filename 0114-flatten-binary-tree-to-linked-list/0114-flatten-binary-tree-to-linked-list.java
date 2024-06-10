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
    public void flatten(TreeNode root) {
        flattenPart(root);
    }
    
    TreeNode flattenPart(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = flattenPart(root.left);
        TreeNode right = flattenPart(root.right);
        
        TreeNode leftPtr = left;
        while (leftPtr != null && leftPtr.right != null) leftPtr = leftPtr.right;
        
        if (leftPtr != null) {
            leftPtr.right = right;
            root.right = left;
        } else {
            root.right = right;
        }
       
        root.left = null;
 
        return root;
    }
    
}