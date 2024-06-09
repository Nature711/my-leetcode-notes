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
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> path = new LinkedList<>();
        LinkedList<String> res = new LinkedList<>();
        backtrack(root, path, res);
        return res;
    }
    

    void backtrack(TreeNode root, LinkedList<String> path, LinkedList<String> res) {
        if (root == null) {
            return;
        }
        // base case
        if (root.left == null && root.right == null) {
            path.addLast(root.val + "");
            res.addLast(String.join("->", path));
            path.removeLast();
            return;
        }
        // do
        path.addLast(root.val + "");
        // backtrack
        backtrack(root.left, path, res);
        backtrack(root.right, path, res);
        // undo
        path.removeLast();
    }
}