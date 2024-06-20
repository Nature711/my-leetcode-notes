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
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    
    List<TreeNode> generate(int low, int high) {
        List<TreeNode> res = new ArrayList<>();
        if (low > high) return res;
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTrees = generate(low, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, high);
            
            if (leftTrees.size() == 0 && rightTrees.size() == 0) {
                    TreeNode root = new TreeNode(i);
                    res.add(root);
            } else if (leftTrees.size() == 0) {
                for (TreeNode rightTree: rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.right = rightTree;
                    res.add(root);
                }
            } else if (rightTrees.size() == 0) {
                for (TreeNode leftTree: leftTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    res.add(root);
                }
            } else {
                for (TreeNode leftTree: leftTrees) {
                    for (TreeNode rightTree: rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        res.add(root);
                    }
                }
            }
        }
        
        return res;
    }
}