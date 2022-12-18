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
    int maxDiameter = 0;
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return maxDiameter;
    }
    
    public int maxDiameter(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int currDiameter = 2 + maxDepth(root.left) + maxDepth(root.right);
        maxDiameter(root.left);
        maxDiameter(root.right);
        maxDiameter = Math.max(maxDiameter, currDiameter);
        memo.put(root, currDiameter);
        return currDiameter;
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}