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
    List<Integer> res = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < res.size(); i++) {
            minDiff = Math.min(minDiff, (res.get(i) - res.get(i - 1)));
        }
        return minDiff;
            
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}