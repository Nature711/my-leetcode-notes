## Path sum 1

- postorder dfs
```

    Stack<TreeNode> stack = new Stack<>();
    Set<TreeNode> peeked = new HashSet<>();
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int currSum = 0;
        
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                currSum += curr.val;
                curr = curr.left;
            }
            curr = stack.peek();
            if (!peeked.add(curr)) {
                if (currSum == targetSum && curr.left == null && curr.right == null) return true;
                currSum -= stack.pop().val;
                curr = null;
            } else curr = curr.right;
        }
        
        return false;
    }
```

- recursive dfs
```
  public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, 0, targetSum);
    }
    
    public boolean dfs(TreeNode node, int currSum, int targetSum) {
        currSum += node.val;
        if (node.left == null && node.right == null && currSum == targetSum) return true;
        if (node.left != null && dfs(node.left, currSum, targetSum)) return true;
        if (node.right != null && dfs(node.right, currSum, targetSum)) return true;
        return false;
    }
 ```
