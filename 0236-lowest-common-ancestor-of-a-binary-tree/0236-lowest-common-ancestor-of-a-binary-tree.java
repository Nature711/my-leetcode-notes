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
    
    HashMap<Integer, Integer> nodeToLevel = new HashMap<>();
    List<List<TreeNode>> paths = new ArrayList<>();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrack(root, new ArrayList<>(), p, q, 0);
        
        int pLevel = nodeToLevel.get(p.val), qLevel = nodeToLevel.get(q.val);
        int minLevel = Math.min(pLevel, qLevel);
        
        for (int i = minLevel; i >= 0; i--) {
            if (paths.get(0).get(i) == paths.get(1).get(i)) return paths.get(0).get(i);
        }
        
        return root;
    }

    void backtrack(TreeNode curr, List<TreeNode> currPath, TreeNode p, TreeNode q, int level) {
            if (curr == null || paths.size() == 2) return;
        
            nodeToLevel.put(curr.val, level);                                                                                             
            currPath.add(curr);
            if (curr == p || curr == q) {
                paths.add(new ArrayList<>(currPath));
            }    
            backtrack(curr.left, currPath, p, q, level + 1);
            backtrack(curr.right, currPath, p, q, level + 1);
            currPath.remove(currPath.size() - 1);
    }       
}