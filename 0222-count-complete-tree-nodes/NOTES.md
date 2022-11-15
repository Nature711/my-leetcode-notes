## Recursion

- T(n) = 2T(n - 1) + 1 --> T(n) = O(2^n)

```
  public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;  
    }
```

## Iterative
```
public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                count++;
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
        return count;
    }
}
```

## Iterative + Binary search
```
class Solution {
  // Return tree depth in O(d) time.
  public int computeDepth(TreeNode node) {
    int d = 0;
    while (node.left != null) {
      node = node.left;
      ++d;
    }
    return d;
  }

  // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
  // Return True if last level node idx exists. 
  // Binary search with O(d) complexity.
  public boolean exists(int idx, int d, TreeNode node) {
    int left = 0, right = (int)Math.pow(2, d) - 1;
    int pivot;
    for(int i = 0; i < d; ++i) {
      pivot = left + (right - left) / 2;
      if (idx <= pivot) {
        node = node.left;
        right = pivot;
      }
      else {
        node = node.right;
        left = pivot + 1;
      }
    }
    return node != null;
  }

  public int countNodes(TreeNode root) {
    // if the tree is empty
    if (root == null) return 0;

    int d = computeDepth(root);
    // if the tree contains 1 node
    if (d == 0) return 1;

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Perform binary search to check how many nodes exist.
    int left = 1, right = (int)Math.pow(2, d) - 1;
    int pivot;
    while (left <= right) {
      pivot = left + (right - left) / 2;
      if (exists(pivot, d, root)) left = pivot + 1;
      else right = pivot - 1;
    }

    // The tree contains 2**d - 1 nodes on the first (d - 1) levels
    // and left nodes on the last level.
    return (int)Math.pow(2, d) - 1 + left;
  }
}
```
