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
    
    int max = 0;
    
    public int longestZigZag(TreeNode root) {
        findZZ(root);
        return max;
    }
    
    public int[] findZZ(TreeNode node) {
        int[] res = new int[2];
        if (node == null) {
            res[0] = -1;
            res[1] = -1;
        } else {
            res[0] = findZZ(node.left)[1] + 1;
            res[1] = findZZ(node.right)[0] + 1;
        }
        max = Math.max(max, Math.max(res[0], res[1]));
        return res;
    }
    
    
}