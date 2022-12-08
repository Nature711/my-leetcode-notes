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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;
        TreeNode curr = root;
        
        while (true) {
            if (val < curr.val && curr.left == null) {
                curr.left = newNode;
                break;
            }
            else if (val > curr.val && curr.right == null) {
                curr.right = newNode;
                break;
            }
            else if (curr.val < val) curr = curr.right;
            else if (curr.val > val) curr = curr.left;
        }
        
        return root;
    }
}