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
    
    public int countDepth(TreeNode root, boolean goLeft) {
        int depth = 0;
        while (root != null) {
            root = goLeft ? root.left : root.right;
            depth++;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int maxDepth = countDepth(root, true);
        int rightDepth = countDepth(root, false);
        
        if (maxDepth == rightDepth) return (int) Math.pow(2, maxDepth) - 1;
        
        int numLeaf = (int) Math.pow(2, maxDepth - 1) - 1;
        TreeNode leftTree = root.left, rightTree = root.right;
        int leftRightDepth = countDepth(leftTree, false), leftDepth = maxDepth - 1;
        
        while (leftTree != null) {  
            if (leftDepth > leftRightDepth) {
                rightTree = leftTree.right;
                leftTree = leftTree.left;
            }
            else {
                numLeaf += (int) Math.pow(2, leftDepth - 1);
                if (rightTree == null) break;
                leftTree = rightTree.left;
                rightTree = rightTree.right;
            }
            leftRightDepth = countDepth(leftTree, false);
            leftDepth--;
        }
        
        return numLeaf;
    }
    
    
}