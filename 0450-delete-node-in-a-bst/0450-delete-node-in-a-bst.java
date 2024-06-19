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
    public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) return root;

        if (root.val == key) {
               if (root.left == null && root.right == null) return null;
                if (root.left == null && root.right != null) return root.right;
                if (root.left != null && root.right == null) return root.left;

                TreeNode newRoot = root.left;
                TreeNode pos = newRoot;
                while (pos.right != null) pos = pos.right;
                pos.right = root.right;
                return newRoot;

        }

        if (root.val < key) {
                root.right = deleteNode(root.right, key);
        } else {
                root.left = deleteNode(root.left, key);
        }
        return root;
    }
}