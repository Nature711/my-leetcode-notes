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
    List<Integer> vals = new ArrayList<>();
    int idx = 0;
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        Collections.reverse(vals);
        int[] prefixSums = new int[vals.size() + 1];
        
        for (int i = 1; i <= vals.size(); i++) {
            prefixSums[i] = vals.get(i - 1) + prefixSums[i - 1];
        }
        
        inorderUpdate(root, prefixSums);
        return root;
    }
    
    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        vals.add(root.val);
        inorder(root.right);
    }
    
    void inorderUpdate(TreeNode root, int[] prefixSums) {
        if (root == null) return;
        inorderUpdate(root.left, prefixSums);
        root.val = prefixSums[prefixSums.length - idx - 1];
        idx++;
        inorderUpdate(root.right, prefixSums);
    }
}