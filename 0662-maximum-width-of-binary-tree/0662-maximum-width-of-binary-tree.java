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
     public int widthOfBinaryTree(TreeNode root) {
         Queue<TreeNode> q = new LinkedList<>();
         root.val = 0;
         q.add(root);
         int maxWidth = 0;
         while (!q.isEmpty()) {
             int low = 0, high = 0;
             int qSize = q.size();
             for (int i = 0; i < qSize; i++) {
                 TreeNode n = q.poll();
                 if (i == 0) low = n.val;
                 if (i == qSize - 1) high = n.val;
                 if (n.left != null) {
                     n.left.val = 2 * n.val;
                     q.add(n.left);
                 }
                 if (n.right != null) {
                     n.right.val = 2 * n.val + 1;
                     q.add(n.right);
                 }
             }
             maxWidth = Math.max(maxWidth, (high - low + 1));
         }
         return maxWidth;
     }
}