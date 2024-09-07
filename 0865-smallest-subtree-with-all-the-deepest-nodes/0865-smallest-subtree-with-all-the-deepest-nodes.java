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
        return LCA(root, nodes);
    }
    
    TreeNode LCA(TreeNode root, List<TreeNode> nodes) {
        if (root == null) return null;
        for (TreeNode node: nodes) {
            if (root == node) return node;
        }
        TreeNode left = LCA(root.left, nodes);
        TreeNode right = LCA(root.right, nodes);
        
        if (left == null && right == null) return null;
        if (left != null && right == null) return left;
        if (left == null && right != null) return right;
        return root;
    }
}