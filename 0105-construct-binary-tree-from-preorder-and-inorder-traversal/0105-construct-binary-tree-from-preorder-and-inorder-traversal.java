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
    int[] pre, in;
    HashMap<Integer, Integer> preMap = new HashMap<>();
    HashMap<Integer, Integer> inMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        int n = preorder.length, low = 0, high = n - 1;
        for (int i = 0; i < n; i++) {
            preMap.put(preorder[i], i);
            inMap.put(inorder[i], i);
        }
        return buildHelper(low, high, low, high);
    }
    
    public TreeNode buildHelper(int preLow, int preHigh, int inLow, int inHigh) {
        if (preLow > preHigh || inLow > inHigh) return null;
        
        TreeNode root = new TreeNode(pre[preLow]);
        
         if (preLow == preHigh || inLow == inHigh) return root;
        
        int idx = inMap.get(root.val);
        
        int leftSize = idx - inLow, rightSize = inHigh - idx;
        
        root.left = buildHelper(preLow + 1, preLow + leftSize, inLow, idx - 1);
        root.right = buildHelper(preLow + leftSize + 1, preLow + leftSize + rightSize, idx + 1, inHigh);
        
        return root;
    }
}