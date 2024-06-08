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
    int max = 0;
    public int maxDepth(TreeNode root) {
        maxDepthHelper(root, 0);
        return max;
    }
    
    public void maxDepthHelper(TreeNode root, int currDepth) {
        if (root == null) {
            max = Math.max(max, currDepth);
            return;
        }
        maxDepthHelper(root.left, currDepth + 1);
        maxDepthHelper(root.right, currDepth + 1);
    }
}