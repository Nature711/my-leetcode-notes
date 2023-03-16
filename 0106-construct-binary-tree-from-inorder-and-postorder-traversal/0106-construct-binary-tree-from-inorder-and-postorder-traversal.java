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
    int[] postordervals;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postordervals = postorder;
        int n = inorder.length;
        for (int i = 0; i < n; i++) map.put(inorder[i], i);
        return builder(0, n - 1, 0, n - 1);
    }
    
    public TreeNode builder(int inLow, int inHigh, int postLow, int postHigh) {
        if (inHigh < inLow || postHigh < postLow) return null;
        int rootVal = postordervals[postHigh];
        int rootIdx = map.get(rootVal);
        int leftSize = rootIdx - inLow, rightSize = inHigh - rootIdx;
        
        TreeNode root = new TreeNode(rootVal);
        root.left = builder(inLow, rootIdx - 1, postLow, postLow + leftSize - 1);
        root.right = builder(rootIdx + 1, inHigh, postHigh - rightSize, postHigh - 1);
        return root;
    }
    
    
}