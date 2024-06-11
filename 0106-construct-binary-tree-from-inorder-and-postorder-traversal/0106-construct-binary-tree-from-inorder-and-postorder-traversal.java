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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }
    
    TreeNode build(int[] inorder, int[] postorder, int rootIdx, int inLow, int inHigh) {
        if (inLow > inHigh) return null;
        
        int rootVal = postorder[rootIdx];
        TreeNode root = new TreeNode(rootVal);
        int rootIdxIn = map.get(rootVal);
        int rightSize = inHigh - rootIdxIn;
        root.left = build(inorder, postorder, rootIdx - rightSize - 1, inLow, rootIdxIn - 1);
        root.right = build(inorder, postorder, rootIdx - 1, rootIdxIn + 1, inHigh);
        
        return root;
    }
}