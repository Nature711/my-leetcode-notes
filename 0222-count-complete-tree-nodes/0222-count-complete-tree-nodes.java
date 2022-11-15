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

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
 
        TreeNode curr = root;
        int depth = 0;
        
        while (curr.left != null) {
            curr = curr.left;
            depth++;
        }
  
        
        int low = 1, high = (int) Math.pow(2, depth) - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (exists(mid, root, depth)) low = mid + 1;
            else high = mid - 1;
        }

        return (int) Math.pow(2, depth) - 1 + low;
        
    }
    
    // returns true if the last node at idx exists in the last row
    public boolean exists(int idx, TreeNode curr, int depth) {
        
        int low = 0, high = (int) Math.pow(2, depth) - 1;
        for (int i = 0; i < depth; i++) {

            int mid = low + (high - low) / 2;
            if (idx <= mid) {
                curr = curr.left;
                high = mid;
            } else {
                curr = curr.right;
                low = mid + 1;
            }
        }
        return curr != null;
        
    }
    
    
}