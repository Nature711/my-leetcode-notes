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

- at r: leftPath = 2, rightPath = 2 --> longestUniValuePath = leftPath + rightPath = 2 + 2 = 4
- r, being called from dfs(r), is just responsible for returning the max between leftPath and rightPath because it can just take on a single path
  -- We can only pass one path calculation, particularly the maximum one, to our parent in the recursive calls. If we didn't perform the max between the two, that would mean our path would not be a single path
  -- As others have pointed out, parent node can choose both left and right branches only if it is the root of this path, i.e.: it is not a part of an existing path yet. This is what the "self.ans = max(self.ans, left_arrow + right_arrow)" does. However, if we want to return something from the recursive function call for this parent node, that means some other node "from above" is calling this parent node. In another word, this parent node is in the middle of an existing path -> it can only choose to go left or right.
