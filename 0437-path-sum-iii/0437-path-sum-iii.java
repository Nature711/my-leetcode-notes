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
    
    int target, count = 0;  
    long currSum = 0;
    HashMap<Long, Integer> map = new HashMap<>();
    
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;

        map.put(currSum, 1);
        preorder(root);
        
        return count;
    }
    
    public void preorder(TreeNode root) {
        if (root == null) return;
        currSum += root.val;
        if (map.containsKey(currSum - target)) {
            count += map.get(currSum - target);
        }
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        preorder(root.left);
        preorder(root.right);
        map.put(currSum, map.get(currSum) - 1);
        currSum -= root.val;
        
    }
    
}