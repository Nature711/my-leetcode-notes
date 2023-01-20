/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //flatten tree
        levelOrder(root);
    
        //bfs
        int n = graph.size();
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        
        while (!queue.isEmpty() && k-- > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                List<TreeNode> nextLevelNodes = graph.get(currNode);
                if (nextLevelNodes == null) break;
                for (TreeNode next: nextLevelNodes) {
                    if (!visited.contains(next)) queue.offer(next);
                    visited.add(next);
                }
            }
        }
        
        
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) res.add(queue.poll().val);
        
        return res;
        
    }
    
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                    TreeNode n1 = currNode, n2 = currNode.left;
                    if (graph.containsKey(n1)) graph.get(n1).add(n2);
                    else {
                        List<TreeNode> list = new ArrayList<>();
                        list.add(n2);
                        graph.put(n1, list);
                    }
                    
                    if (graph.containsKey(n2)) graph.get(n2).add(n1);
                    else {
                        List<TreeNode> list = new ArrayList<>();
                        list.add(n1);
                        graph.put(n2, list);
                    }
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                    TreeNode n1 = currNode, n2 = currNode.right;
                    if (graph.containsKey(n1)) graph.get(n1).add(n2);
                    else {
                        List<TreeNode> list = new ArrayList<>();
                        list.add(n2);
                        graph.put(n1, list);
                    }
                    
                    if (graph.containsKey(n2)) graph.get(n2).add(n1);
                    else {
                        List<TreeNode> list = new ArrayList<>();
                        list.add(n1);
                        graph.put(n2, list);
                    }
                }
            }
                
        }
    
    }
}