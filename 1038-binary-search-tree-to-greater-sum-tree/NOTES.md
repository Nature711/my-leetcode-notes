## Recursion
```
  int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        
        if(root!=null)
        {
            bstToGst(root.right);
            sum+=root.val;
            root.val=sum;
            bstToGst(root.left);
        }
        return root;
    }
 ```
 
 ## Reverse inorder
 ```
    Stack<TreeNode> stack = new Stack<>();
    
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        
        int acc = 0;
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            acc +=  currNode.val;
            currNode.val = acc;
        }
        
        return root;
    }
    
    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        stack.push(node);
        inorder(node.right);
    }
    
 ```
