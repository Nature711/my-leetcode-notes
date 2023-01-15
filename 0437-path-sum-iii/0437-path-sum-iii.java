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
    
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>(); 
        //a map of the cumulative sum and the number of times it had occured
        
        
        long currSum = 0;
        int count = 0;
        map.put(currSum, 1); //at root
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        Set<TreeNode> peeked = new HashSet<>();

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                //System.out.println("add " + curr.val + " to sum");
                currSum += curr.val;
                map.put(currSum, map.getOrDefault(currSum, 0) + 1);
                if (map.containsKey(currSum - targetSum)) {
                    count += map.get(currSum - targetSum);
                    if (targetSum == 0) count--;
                }
                //System.out.println(currSum + " " + map);
                curr = curr.left;
            }        
            curr = stack.peek();
            if (!peeked.add(curr)) {
                TreeNode r = stack.pop();
                map.put(currSum, map.get(currSum) - 1);
                currSum -= r.val; 
                //System.out.println("remove " +r.val + " from sum");
                curr = null;
                //System.out.println(currSum + " " + map);
            } else curr = curr.right; 
        }
        return count;
    }
    
   

}