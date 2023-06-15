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
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.getKey() != p2.getKey()) return p2.getKey() - p1.getKey();
            else return p1.getValue() - p2.getValue();
        });
        int maxSum = 0, level = 1;
        while (!q.isEmpty()) {
            int size = q.size(), levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                levelSum += curr.val;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            pq.add(new Pair<>(levelSum, level));
            level++;
        }
        //System.out.println(pq);
        Pair<Integer, Integer> res = pq.poll();
        return res.getValue();
    }
}