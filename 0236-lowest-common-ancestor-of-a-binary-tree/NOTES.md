### Intutition
- case 1: both left and right subtree collapse to a single node -- must be the case that one collpases to p and the other to q --> LCA of them is just the current root
- case 2: both left and right subtree collapse to null --> p, q not found in both subtree --> return null
- case 3: left subtree collapses to a single value (either p or q) and right subtree collapses to null --> both p,q exists in left subtree --> return LCA(root.left)
- case 4: right subtree collapses to a single value (either p or q) and left subtree collapses to null --> both p,q exists in right subtree --> return LCA(root.right)

![image](https://user-images.githubusercontent.com/77217430/206827817-5ef9d34c-87d7-4a04-addd-f8b3e5daa856.png)

```
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root; //case 1
        if (left == null && right == null) return null; //case 2
        if (left != null) return left; //case 3, i.e., left != null && right == null
        else return right; //case 4, i.e., left == null && right != null
    }
```

