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
    List<Integer> nodes = new ArrayList<>();
    int idx = 0;
    public void recoverTree(TreeNode root) {
        inorder(root);
        Collections.sort(nodes);
        // System.out.println(nodes);
        inorder2(root);
    }
    
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
    }
    
    public void inorder2(TreeNode root) {
        if (root == null) return;
        inorder2(root.left);
        root.val = nodes.get(idx++);
        inorder2(root.right);
    }
}