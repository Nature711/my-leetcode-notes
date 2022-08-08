## Wrong attempt
```
public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        boolean isCurrValid = true;
        if ((root.left != null && root.left.val >= root.val) 
            || (root.right != null && root.right.val <= root.val)) {
            isCurrValid = false;
        }
        
        return isCurrValid && isValidBST(root.left) && isValidBST(root.right);
        
    }
```

## Correct but inefficient
```
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        List<Integer> leftTreeNodeVals = new ArrayList<>();
        dfs(root.left, leftTreeNodeVals);
        for (int nodeVal: leftTreeNodeVals) if (nodeVal >= root.val) return false;
        
        List<Integer> rightTreeNodeVals = new ArrayList<>();
        dfs(root.right, rightTreeNodeVals);
        for (int nodeVal: rightTreeNodeVals) if (nodeVal <= root.val) return false;
        
        return isValidBST(root.left) && isValidBST(root.right);
        
    }
    
    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
 ```
 
 ## Correct and optimized
 ```
  public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBSTHelper(TreeNode root, long low, long high) {
        if (root == null) return true;
        
        if (root.val >= high || root.val <= low) return false;
        
        return isValidBSTHelper(root.left, low, root.val)
            && isValidBSTHelper(root.right, root.val, high);
        
    }
 ```
