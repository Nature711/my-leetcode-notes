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
    
    List<List<Integer>> paths = new ArrayList<>();
    int target;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        dfs(root, targetSum, new ArrayList<>());
        return paths;
    }
    
    public void dfs(TreeNode root, int rem, List<Integer> currPath) {
        if (root == null) return;
        
        if (root.left == null && root.right == null && rem == root.val) {
            currPath.add(root.val);
            paths.add(new ArrayList<>(currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }
        
        currPath.add(root.val);
        dfs(root.left, rem - root.val, currPath);
        currPath.remove(currPath.size() - 1);
        
        currPath.add(root.val);
        dfs(root.right, rem - root.val, currPath);
        currPath.remove(currPath.size() - 1);
    }
    
}
    
    
    