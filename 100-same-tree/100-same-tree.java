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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            
            if (t1 == null && t2 == null) continue;
            if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) return false;
            
            if (t1.val != t2.val) return false;
            
            q1.offer(t1.left);
            q1.offer(t1.right);
            q2.offer(t2.left);
            q2.offer(t2.right);
        }
        
        if (q1.isEmpty() && q2.isEmpty()) return true;
        else return false;
    }
}