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
        StringBuilder sb = new StringBuilder(Integer.toString(root.val));
        backtrack(root, sb);
        int sum = 0;
        for (int num: nums) sum += num;
        return sum;
    }
    
    public void backtrack(TreeNode root, StringBuilder currPath) {
        if (root.left == null && root.right == null) {
            int num = Integer.valueOf(currPath.toString());
            nums.add(num);
            return;
        }
        
        if (root.left != null) {
            currPath.append(Integer.toString(root.left.val));
            backtrack(root.left, currPath);
            currPath.deleteCharAt(currPath.length() - 1);
        }
        if (root.right != null) {
            currPath.append(Integer.toString(root.right.val));
            backtrack(root.right, currPath);
            currPath.deleteCharAt(currPath.length() - 1);
        }
    }
}