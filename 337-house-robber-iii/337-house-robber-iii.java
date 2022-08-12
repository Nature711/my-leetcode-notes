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
    
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    
    public int rob(TreeNode root) {
        return dfs(root);
    }
    
    public int dfs(TreeNode entry) {
        if (entry == null) return 0;
        
        if (memo.containsKey(entry)) return memo.get(entry);
        
        int amountIfTake = entry.val;
        int amountIfNotTake = 0;
        
        if (entry.left != null) amountIfTake += dfs(entry.left.left) + dfs(entry.left.right);
        if (entry.right != null) amountIfTake += dfs(entry.right.left) + dfs(entry.right.right);
        
        amountIfNotTake += dfs(entry.left) + dfs(entry.right);
        
        int result = Math.max(amountIfTake, amountIfNotTake);
        memo.put(entry, result);
        return result;
    }
}