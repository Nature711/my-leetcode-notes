## Iterative
```
   public boolean isSymmetric(TreeNode root) {
    
        if (root == null ||(root.left == null && root.right == null)) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (queue.peek() == root) {
                TreeNode currNode = queue.poll();
                queue.offer(currNode.left);
                queue.offer(currNode.right);
                continue;
            }
            if (size % 2 != 0) return false;
            for (int i = 0; i < size / 2; i++) {
                TreeNode currNode = queue.poll();
                if (currNode != null) {
                    stack.push(currNode.val);
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                } else stack.push(101);
            }
            for (int i = 0; i < size / 2; i++) {
                TreeNode currNode = queue.poll();
                if (stack.isEmpty()) return false;
                if (currNode != null) {
                    if (stack.pop() != currNode.val) return false;
                    queue.offer(currNode.left);
                    queue.offer(currNode.right);
                } else {
                    if (stack.pop() != 101) return false;
                }
            }
        }
        
        return true;
    }
  ```
  
## Recursive
  
```
   public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
    
    public boolean isSymmetricHelper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null && t2 != null || t1 != null && t2 == null) return false;
        return t1.val == t2.val && isSymmetricHelper(t1.left, t2.right) && isSymmetricHelper(t1.right, t2.left); 
    }
```
