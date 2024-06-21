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
    List<List<TreeNode>> paths = new ArrayList<>();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrack(root, new ArrayList<>(), p, q, 0);
        
        int minLevel = Math.min(paths.get(0).size(), paths.get(1).size());
        for (int i = minLevel - 1; i >= 0; i--) {
            if (paths.get(0).get(i) == paths.get(1).get(i)) return paths.get(0).get(i);
        }
        
        return root;
    }

    void backtrack(TreeNode curr, List<TreeNode> currPath, TreeNode p, TreeNode q, int level) {
            if (curr == null || paths.size() == 2) return;                                                                                           
            currPath.add(curr);
            if (curr == p || curr == q) {
                paths.add(new ArrayList<>(currPath));
            }    
            backtrack(curr.left, currPath, p, q, level + 1);
            backtrack(curr.right, currPath, p, q, level + 1);
            currPath.remove(currPath.size() - 1);
    }       
}