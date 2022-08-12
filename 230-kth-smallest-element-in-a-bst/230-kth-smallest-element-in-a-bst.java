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
    
    List<Integer> nodes = new ArrayList<>();
    int targetSize = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        targetSize = k;
        dfs(root);
        return nodes.get(k - 1);
    }
    
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (nodes.size() == targetSize) return; 
        nodes.add(root.val);
        if (nodes.size() == targetSize) return;
        dfs(root.right);
        if (nodes.size() == targetSize) return;
    }
}