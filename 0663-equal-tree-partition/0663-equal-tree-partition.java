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
    Stack<Integer> subtreeSums = new Stack<>();
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return true;
        int totalSum = subtreeSum(root);
        int target = totalSum / 2;
        subtreeSums.pop();
        if (totalSum % 2 == 0) {
            for (int sum: subtreeSums) if (sum == target) return true;
        }
        return false;
    }
    
    public int subtreeSum(TreeNode root) {
        if (root == null) return 0;
        subtreeSums.push(root.val + subtreeSum(root.left) + subtreeSum(root.right));
        return subtreeSums.peek();
    }
}