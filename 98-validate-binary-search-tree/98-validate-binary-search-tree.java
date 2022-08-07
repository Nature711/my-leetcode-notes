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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        List<Integer> leftTreeNodeVals = new ArrayList<>();
        dfs(root.left, leftTreeNodeVals);
        for (int nodeVal: leftTreeNodeVals) if (nodeVal >= root.val) return false;
        
        List<Integer> rightTreeNodeVals = new ArrayList<>();
        dfs(root.right, rightTreeNodeVals);
        for (int nodeVal: rightTreeNodeVals) if (nodeVal <= root.val) return false;
        
        return isValidBST(root.left) && isValidBST(root.right);
        
    }
    
    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
    
}