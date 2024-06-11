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
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    TreeNode build(int[] preorder, int[] inorder, int preLow, int inLow, int inHigh) {
        if (inLow > inHigh) return null;
        
        int rootVal = preorder[preLow];
        TreeNode root = new TreeNode(rootVal);
        int inorderIdx = map.get(rootVal);
        root.left = build(preorder, inorder, preLow + 1, inLow, inorderIdx - 1);
        int leftTreeSize = inorderIdx - inLow;
        root.right = build(preorder, inorder, preLow + leftTreeSize + 1, inorderIdx + 1, inHigh);
        return root;
    }
}