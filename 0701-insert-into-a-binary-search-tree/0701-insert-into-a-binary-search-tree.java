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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode dummy = new TreeNode();
        dummy.left = root;
        TreeNode prev = dummy, curr = root;
        boolean toLeft = true;
        while (curr != null) {
                prev = curr;
                if (curr.val < val) {
                        curr = curr.right;
                        toLeft = false;
                } else {
                        curr = curr.left;
                        toLeft = true;
                }
        }
        if (toLeft) prev.left = new TreeNode(val);
        else prev.right = new TreeNode(val);

        return dummy.left;
    }
}