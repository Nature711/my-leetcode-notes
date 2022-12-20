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
    int res = -1, count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        preorder(root);
        return res;
    }
    
    public void preorder(TreeNode root) {
        if (res != -1 || root == null) return;
        preorder(root.left);
        count--;
        if (count == 0) res = root.val;
        preorder(root.right);
    }
}