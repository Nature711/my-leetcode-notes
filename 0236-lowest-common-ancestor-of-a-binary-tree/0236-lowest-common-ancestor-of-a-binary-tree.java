/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }
    
    TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) return null;
        
        if (root.val == val1 || root.val == val2) return root;
        
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);
        
        if (left != null && right != null) return root;
        
        return left != null ? left : right;
    }

}