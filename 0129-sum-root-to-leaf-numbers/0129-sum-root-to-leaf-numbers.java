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
    List<Integer> nums = new ArrayList<>();
    
    public int sumNumbers(TreeNode root) {
        backtrack(root, new StringBuilder());
        int sum = 0;
        for (int num: nums) sum += num;
        return sum;
    }
    
    public void backtrack(TreeNode root, StringBuilder currPath) {
        if (root.left == null && root.right == null) {
            currPath.append(Integer.toString(root.val));
            int num = Integer.valueOf(currPath.toString());
            nums.add(num);
            currPath.deleteCharAt(currPath.length() - 1);
            return;
        }
        
        currPath.append(Integer.toString(root.val));
        if (root.left != null) backtrack(root.left, currPath);
        if (root.right != null) backtrack(root.right, currPath);
        currPath.deleteCharAt(currPath.length() - 1);
        
    }
}