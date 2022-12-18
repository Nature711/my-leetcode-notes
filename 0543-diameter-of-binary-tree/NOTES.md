## Diameter of Binary Tree
- goal: find the longest distance between any pair of nodes in the whole tree

```
            1
          /   \
         2     3
        / \
       4   5
            \
             6
            / \
          ...  ...
```

- observation:
  - the longest path MAY NOT pass through root

### Straightforward
```
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return maxDiameter;
    }
    
    public int maxDiameter(TreeNode root) {
        if (root == null) return 0;
        int currDiameter = 2 + maxDepth(root.left) + maxDepth(root.right);
        maxDiameter(root.left);
        maxDiameter(root.right);
        maxDiameter = Math.max(maxDiameter, currDiameter);
        return currDiameter;
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
```

## Optimized: updating of max diameter is done during computing depth from each node 
```
 int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return -1;

        int leftDepth = maxDepth(root.left), rightDepth = maxDepth(root.right);
        int currDiameter = leftDepth + rightDepth + 2;
        maxDiameter = Math.max(currDiameter, maxDiameter);
        return 1 + Math.max(leftDepth, rightDepth);
    }
 ```
 
 ## Sample solution
 ```
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return maxDiameter;
    }
    
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }
```
