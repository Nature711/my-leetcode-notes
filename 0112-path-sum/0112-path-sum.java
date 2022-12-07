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
    
    Stack<TreeNode> stack = new Stack<>();
    Set<TreeNode> peeked = new HashSet<>();
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int currSum = 0;
        
        TreeNode curr = root;
        
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                currSum += curr.val;
                curr = curr.left;
            }
         
            curr = stack.peek();
            
            if (!peeked.add(curr)) {
                if (currSum == targetSum && curr.left == null && curr.right == null) return true;
                currSum -= stack.pop().val;
                curr = null;
            } else curr = curr.right;
        }
        
        return false;
    }
}

