## Recursion
```
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
 
