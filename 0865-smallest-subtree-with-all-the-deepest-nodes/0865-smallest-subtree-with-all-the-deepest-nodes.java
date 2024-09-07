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
    class Result {
        TreeNode node; // root of subtree with all deepest nodes  
        int depth; // depth of those deepest nodes
        public Result(TreeNode node, int depth) {
            // 记录最近公共祖先节点 node
            this.node = node;
            // 记录以 node 为根的二叉树最大深度
            this.depth = depth;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Result r = helper(root);
        return r.node;
    }
    
    Result helper(TreeNode root) {
        if (root == null) return new Result(null, 0);
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (left.depth == right.depth) return new Result(root, left.depth + 1);
        if (left.depth > right.depth) return new Result(left.node, left.depth + 1);
        return new Result(right.node, right.depth + 1);
    }
}