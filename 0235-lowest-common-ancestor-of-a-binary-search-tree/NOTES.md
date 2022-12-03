## iterative

```
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode commonAns = root;
        
        while (true) {
            if (p.val < commonAns.val && q.val < commonAns.val) {
                commonAns = commonAns.left;
            } else if (p.val > commonAns.val && q.val > commonAns.val) {
                commonAns = commonAns.right;
            } else break;
        }
        return commonAns;
    }
```

## recursive

- we're sure root can't be null at point 1 since:
  - to reach point 1 we need to pass the first line check
  - to pass we need to have root != p && root != q
  - since both p, q are not null (given), we're sure root != null\
  - thus we can savely access root.val below
  
```
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        
        //point 1
        
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
```
