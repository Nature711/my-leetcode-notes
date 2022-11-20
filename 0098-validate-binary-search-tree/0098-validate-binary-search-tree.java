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
    public boolean isValidBST(TreeNode root) {
        
        dfs(root);
        
        for (int i = 0; i < nodes.size() - 1; i++) if (nodes.get(i) >= nodes.get(i + 1)) return false;
        return true;
    }
    
    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        nodes.add(node.val);
        dfs(node.right);
    }
    
}