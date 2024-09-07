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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        List<TreeNode> nodes = new ArrayList<>();
        while (!q.isEmpty()) {
            int n = q.size();
            nodes = new ArrayList<>(); // clear list to store the nodes at the current level
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                nodes.add(curr);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return lowestCommonAncestor(root, nodes.get(0), nodes.get(nodes.size() - 1));
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root == p) return p;
        if (root == q) return q;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left == null && right == null) return null;
        if (left != null && right == null) return left;
        if (left == null && right != null) return right;
        return root;
    }
}