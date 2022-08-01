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
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root != null) backtrack(root, targetSum, new ArrayList<>());
        return paths;
    }
    
    public void backtrack(TreeNode curr, int rem, List<Integer> currPath) {
        if (curr == null) return;
        
        rem -= curr.val;
        
        if (curr.left == null && curr.right == null) {
            if (rem == 0) {
                currPath.add(curr.val);
                paths.add(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);
            }
            return;
        }
        
        if (curr.left != null) {
            currPath.add(curr.val);
            backtrack(curr.left, rem, currPath);
            currPath.remove(currPath.size() - 1);
        }
        
        if (curr.right != null) {
            currPath.add(curr.val);
            backtrack(curr.right, rem, currPath);
            currPath.remove(currPath.size() - 1);
        }
        
        
    }
}