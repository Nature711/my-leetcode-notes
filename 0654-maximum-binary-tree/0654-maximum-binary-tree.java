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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
        
    }
    
    TreeNode construct(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        
        int max = -1, idx = -1;
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        root.left = construct(nums, low, idx - 1);
        root.right = construct(nums, idx + 1, high);
        return root;
    }
}