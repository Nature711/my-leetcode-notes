## Wrong
```
   public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        
        return root;
    }
```

## Correct
```
   public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftSubTree = root.left;
        TreeNode rightSubTree = root.right;
       
        root.left = invertTree(rightSubTree);
        root.right = invertTree(leftSubTree);
        
        return root;
    }
 ```
