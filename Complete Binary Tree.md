## Properties
![image](https://user-images.githubusercontent.com/77217430/201814033-b8695e35-10e5-4eaa-97fe-c3fdb048c962.png)

## Compute height for complete binary tree

- assuming root has depth 0
- by property of complete binary tree --> leftmost tree has max height
- thus we only need to traverse to left every time --> trying to go as far left as possible 
- time: O(h) = O(logN)

```
public int computeDepth(TreeNode node) {
    int d = 0;
    while (node.left != null) {
      node = node.left;
      ++d;
    }
    return d;
  }
```
