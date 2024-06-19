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
        TreeNode dummy = new TreeNode();
        dummy.left = root;
        TreeNode curr = root, prev = dummy;
        while (curr != null && curr.val != key) {
                prev = curr;
                if (curr.val < key) curr = curr.right;
                else curr = curr.left;
        }
        if (curr == null) return root;
        
        boolean isLeft = true;
        if (prev.right == curr) isLeft = false;

        TreeNode tmpLeft = curr.left, tmpRight = curr.right;
        if (isLeft) {
            prev.left = tmpLeft == null ? tmpRight : tmpLeft;
        }
        else {
            prev.right = tmpLeft == null ? tmpRight : tmpLeft;
        } 
        
        TreeNode pos;
        if (tmpLeft != null) {
            pos = tmpLeft;
            while (pos != null && pos.right != null) pos = pos.right;
            if (pos != null) pos.right = tmpRight;
        } else {
            pos = tmpRight;
            while (pos != null && pos.left != null) pos = pos.left;
            if (pos != null) pos.left = tmpLeft;
        }

        return dummy.left == null ? dummy.right : dummy.left;
    }
}