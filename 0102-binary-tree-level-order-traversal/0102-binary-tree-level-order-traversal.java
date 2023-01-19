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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    public void dfs(TreeNode root, int level) {
        if (root == null) return;
        
        if (level >= res.size()) {
            List<Integer> currLevel = new ArrayList<>();
            currLevel.add(root.val);
            res.add(level, currLevel);
        } else {
            res.get(level).add(root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}