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
    List<String> paths = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        return getPaths(root);
    }
    
    public List<String> getPaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }
        
        List<String> left = getPaths(root.left);
        List<String> right = getPaths(root.right);
        
        
        for (String path: left) {
            res.add(root.val + "->" + path);
        }
        for (String path: right) {
            res.add(root.val + "->" + path);
        }
        
        return res;
    }
     
}