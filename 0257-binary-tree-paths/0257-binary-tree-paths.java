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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        return dfs(root);
    }
    
    public List<String> dfs(TreeNode root) {
        List<String> res = new ArrayList<>();
        
        if (root.left != null) {
            List<String> leftTrees = dfs(root.left);
            for (String leftTree: leftTrees) {
                res.add(root.val + "->" + leftTree);
            }
        }
        if (root.right != null) {
            List<String> rightTrees = dfs(root.right);
            for (String rightTree: rightTrees) {
                res.add(root.val + "->"  + rightTree);
            }
        }
        if (res.size() == 0) {
            res.add(Integer.toString(root.val));
        }
        
        return res;
    }
}