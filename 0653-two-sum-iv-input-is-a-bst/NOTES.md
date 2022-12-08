## inorder traversal converting to sorted array
```
public boolean findTarget(TreeNode root, int k) {
    List<Integer> inorder = inorderTraversal(root);

    int low = 0, high = inorder.size() - 1;
    while (low < high) {
        int sum = inorder.get(low) + inorder.get(high);
        if (sum == k) return true;
        else if (sum < k) low++;
        else high--;
    }
    return false;
}

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }        
        curr = stack.pop();
        res.add(curr.val);
        curr = curr.right;   
    }
    return res;
}
```

## Finding complement & storing seen value in HashSet
```
public boolean findTarget(TreeNode root, int k) {
    HashSet<Integer> seen = new HashSet<>();

    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode curr = queue.poll();
            if (seen.contains(k - curr.val)) return true;
            seen.add(curr.val);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    return false;
}
```
