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
        int leftRange = Integer.MIN_VALUE, rightRange = Integer.MAX_VALUE;
        
        while (true) {
            if ((p.val > leftRange && p.val < commonAns.val) && (q.val > leftRange && q.val < commonAns.val)) {
                rightRange = commonAns.val;
                commonAns = commonAns.left;
            } else if ((p.val < rightRange && p.val > commonAns.val) && (q.val < rightRange && q.val > commonAns.val)) {
                leftRange = commonAns.val;
                commonAns = commonAns.right;
            } else break;
        }
        return commonAns;
    }
}