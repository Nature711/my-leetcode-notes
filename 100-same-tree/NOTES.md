## Recursion

```
 public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
```

## Level order tranversal (BFS)
```
 public boolean isSameTree(TreeNode p, TreeNode q) {
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            
            if (t1 == null && t2 == null) continue;
            if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) return false;
            
            if (t1.val != t2.val) return false;
            
            q1.offer(t1.left);
            q1.offer(t1.right);
            q2.offer(t2.left);
            q2.offer(t2.right);
        }
        
        if (q1.isEmpty() && q2.isEmpty()) return true;
        else return false;
    }
```
