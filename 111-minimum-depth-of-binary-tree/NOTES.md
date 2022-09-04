## DFS (recursion)
- if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left, right) + 1
- if a node has two children on both side -> return min depth of two sides, i.e. MIN(left, right) + 1
```
 public int minDepth(TreeNode root) {
        if (root == null) return 0;
        
        if (root.left == null && root.right != null) return minDepth(root.right) + 1;
        
        if (root.left != null && root.right == null) return minDepth(root.left) + 1;
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
```


## BFS
```
 public int minDepth(TreeNode root) {
        
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.remove();
                if (currNode.left == null && currNode.right == null) return depth;
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
           
            depth++;
        }
        
       return depth;
    }
 ```
 
