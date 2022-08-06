## Recursive DFS
```
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum(root.left, targetSum - root.val)
            || hasPathSum(root.right, targetSum - root.val);
    }
 ```
 
 ## Backtracking
 
 ### Wrong 
 ```
     public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean[] hasPath = new boolean[] {false};
        
        backtrack(hasPath, root, 0, targetSum);
        
        return hasPath[0];
    }
    
    public void backtrack(boolean[] hasPath, TreeNode curr, int currSum, int targetSum) {
        if (curr == null) return;
        if (curr.left == null && curr.right == null) {
            if (currSum == targetSum) hasPath[0] = true;
            return;
        }
        
        backtrack(hasPath, curr.left, currSum + curr.val, targetSum);
        backtrack(hasPath, curr.right, currSum + curr.val, targetSum);
    }
 ```
 
 ### Right -- using global variable
 ```
 class Solution {
    int sum = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
		// condition to end the backtrack
        if(root == null) return false;
		
        //choose
        sum += root.val;   
		
		//explore
        if(root.right == null && root.left == null && sum == targetSum) {
            return true;
        } else {
             if(hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum)) return true;
        }
        //unchoose: 
        sum -= root.val;
        
        return false;        
    }
}

 ```
 
 ## Iterative DFS
 ```
  public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        
        stack.add(new Pair<>(root, root.val));
        
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> curr = stack.pop();
            TreeNode currNode = curr.getKey();
            int currSum = curr.getValue();
        
            if (currNode.left == null && currNode.right == null 
                && currSum == targetSum) {
                return true;
            }
            
            if (currNode.left != null) {
                stack.add(new Pair<>(currNode.left, currSum + currNode.left.val));
            }
            if (currNode.right != null) {
                stack.add(new Pair<>(currNode.right, currSum + currNode.right.val));
            }
            
        }
        
        return false;
    }
 ```
 
 
