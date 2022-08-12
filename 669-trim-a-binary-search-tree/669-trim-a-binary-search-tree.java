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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        
        TreeNode leftTree = trimBST(root.left, low, high);
        TreeNode rightTree = trimBST(root.right, low, high);
        
        if (root.val >= low && root.val <= high) {
            root.left = leftTree;
            root.right = rightTree;
            return root;
        } else {
            if (leftTree != null) return leftTree;
            if (rightTree != null) return rightTree;
            return null;
        }
    }
    
    
}