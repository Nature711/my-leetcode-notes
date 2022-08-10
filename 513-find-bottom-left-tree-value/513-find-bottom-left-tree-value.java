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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> lastRow = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int count = queue.size();
            lastRow = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode currNode = queue.poll();
                lastRow.add(currNode);
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
        }
        
        return lastRow.get(0).val;
    }
}