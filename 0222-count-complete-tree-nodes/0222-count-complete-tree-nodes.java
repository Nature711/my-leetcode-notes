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
    
    public int countDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftDepth = countDepth(root.left);
        int rightDepth = countDepth(root.right);
        
        if (leftDepth == rightDepth + 1) 
            return countNodes(root.left) + (int)Math.pow(2, rightDepth);
        else return countNodes(root.right) + (int)Math.pow(2, leftDepth);
    }
    
    
}