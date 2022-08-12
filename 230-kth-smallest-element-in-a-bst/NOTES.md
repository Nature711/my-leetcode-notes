## Idea: Inorder traversal on BST prints the nodes ascending order

## Implementation

### Normal inorder traversal, recursive
```
  public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
    if (root == null) return arr;
    inorder(root.left, arr);
    arr.add(root.val);
    inorder(root.right, arr);
    return arr;
  }

  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
    return nums.get(k - 1);
  }
```

### Modified recursive inorder traversal, terminated early
```
    List<Integer> nodes = new ArrayList<>();
    int targetSize = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        targetSize = k;
        dfs(root);
        return nodes.get(k - 1);
    }
    
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (nodes.size() == targetSize) return; 
        nodes.add(root.val);
        if (nodes.size() == targetSize) return;
        dfs(root.right);
        if (nodes.size() == targetSize) return;
    }
```

### Iterative inorder traversal

```
         4
       /   \
      2     5
    /   \
   1     3 
```

```
  public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        
        while(true) {
        
            while (root != null) {
                stack.push(root);
                root = root.left;
            } //keep traversing down the left subtree, adding all the nodes to stack but not visting them 
            
            root = stack.pop(); //the node that's being popped out its the leftmost node in the leftsubtree 
            //(i.e., the node that's just added before the left subtree becomes null) -- LIFO feature of stack
            
            count++;
            if (count == k) return root.val; 
            
            root = root.right; //only after fully exploring the left subtree do we start to explore right subtree
        }

    }
 ```
root at 4
while (root != null)
- 4 --> pushed to stack [4], updating root to 2
- 2 --> pushed to stack [4 2], updating root to 1
- 1 --> pushed to stack [4 2 1], updating root to null
now root is null, start popping 
- pop 1 and assign to root --> 1 is the 1st node being explored
- update root to the right of 1 which is null
- skip while loop, pop 3 and assign to root --> 2 is the 2nd node being explored 
- update root to the right of 2 which is 3 --> enforcing the inorder traversal order
