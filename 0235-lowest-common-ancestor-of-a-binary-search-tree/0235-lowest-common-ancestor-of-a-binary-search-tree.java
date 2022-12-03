/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode commonAns = root;
        
        while (true) {
            if (p.val < commonAns.val && q.val < commonAns.val) {
                commonAns = commonAns.left;
            } else if (p.val > commonAns.val && q.val > commonAns.val) {
                commonAns = commonAns.right;
            } else break;
        }
        return commonAns;
    }
}