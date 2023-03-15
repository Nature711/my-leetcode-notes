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
    public boolean isCompleteTree(TreeNode root) {
        int h = findHeight(root) - 1;
        if (h == 0) return true;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currLevel = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            if (currLevel != h - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode curr = q.poll();
                    if (curr.left == null || curr.right == null) return false;
                    q.add(curr.left);
                    q.add(curr.right);
                }
            } else {
                boolean hasMore = true;
                for (int i = 0; i < size; i++) {
                    TreeNode curr = q.poll();
                    if (curr.left != null && !hasMore) return false;
                    if (curr.left == null && curr.right != null) return false;
                    if (curr.right == null) hasMore = false;
                }
            }
            
            currLevel++;
        }
        return true;
    }
    
    public int findHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
}