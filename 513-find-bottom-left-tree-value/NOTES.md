## Naive
```
   public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> lastRow = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            int count = queue.size();
            lastRow = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode currNode = queue.poll();
                lastRow.add(currNode);
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
        }
        
        return lastRow.get(0).val;
    }
```

## Optimized: Right-to-left BFS
```
        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
```
- add 1 [1]
- poll 1 []
- from 1 add 3, 2 [3, 2]
- poll 3 [2]
- from 3 add 6, 5 [2, 6, 5]
- poll 2 [6, 5]
- from 2 add 4 [6, 5, 4]
- poll 6 [5, 4]
- from 6 add nothing [5, 4]
- poll 5 [4]
- from 5 add 7 [4, 7]
- poll 4 [7]
- from 4 add nothing [7]
- poll 7
- from 7 add nothing []
- q is empty --> return 7

```
public int findLeftMostNode(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        root = queue.poll();
        if (root.right != null)
            queue.add(root.right);
        if (root.left != null)
            queue.add(root.left);
    }
    return root.val;
}
```
