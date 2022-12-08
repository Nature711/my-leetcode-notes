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
