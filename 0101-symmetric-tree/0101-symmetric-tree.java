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
    public boolean isSymmetric(TreeNode root) {
    
        if (root == null ||(root.left == null && root.right == null)) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (queue.peek() == root) {
                TreeNode currNode = queue.poll();
                queue.offer(currNode.left);
                queue.offer(currNode.right);
                continue;
            }
            if (size % 2 != 0) return false;
            for (int i = 0; i < size / 2; i++) {
                TreeNode currNode = queue.poll();
                if (currNode != null) {
                    stack.push(currNode.val);
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                } else stack.push(101);
            }
            for (int i = 0; i < size / 2; i++) {
                TreeNode currNode = queue.poll();
                if (stack.isEmpty()) return false;
                if (currNode != null) {
                    if (stack.pop() != currNode.val) return false;
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                } else {
                    if (stack.pop() != 101) return false;
                }
            }
        }
        
        return true;
    }
}