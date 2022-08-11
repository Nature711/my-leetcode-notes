```
     1
      \
       1
     /   \
    1     1
   / \    /
  1   1  1
```
- longest univalue path length = 4

```
     1
      \
       1 <- r
     /   \
a-> 1     1 <-b
   / \    /
  1   1  1
```
node r as root
- leftPath, rightPath initialized to 0
- r has both left and right child
//dfs(r.left) returns the max univalue length using r.left as root
- if (r has left child && r.val == r.left.val), then leftPath = dfs(r.left) + 1
- if (r has right child && r.val == r.right.val), then rightPath = dfs(r.right) + 1
//the checking of leftPath and rightPath are independent from each other
- if r doesn't have left child, then leftPath will remain 0
- if r doesn't have right child, then rightPath will remain 0
- r, being called from dfs(r), is just responsible for returning the max between leftPath and rightPath
