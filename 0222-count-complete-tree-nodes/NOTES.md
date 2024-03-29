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

## Optimized iterative
![image](https://user-images.githubusercontent.com/77217430/201814608-3a0450ad-3e7f-4d91-88fd-8959fe163118.png)

```
    public int countDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftDepth = countDepth(root.left);
        int rightDepth = countDepth(root.right);
        
        if (leftDepth == rightDepth + 1) 
            return countNodes(root.left) + (int)Math.pow(2, rightDepth);
        else return countNodes(root.right) + (int)Math.pow(2, leftDepth);
    }
    
```

## Two pointers
```
public int countDepth(TreeNode root, boolean goLeft) {
        int depth = 0;
        while (root != null) {
            root = goLeft ? root.left : root.right;
            depth++;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int maxDepth = countDepth(root, true);
        int rightDepth = countDepth(root, false);
        
        if (maxDepth == rightDepth) return (int) Math.pow(2, maxDepth) - 1;
        
        int numLeaf = (int) Math.pow(2, maxDepth - 1) - 1;
        TreeNode leftTree = root.left, rightTree = root.right;
        int leftRightDepth = countDepth(leftTree, false), leftDepth = maxDepth - 1;
        
        while (leftTree != null) {  
            if (leftDepth > leftRightDepth) {
                rightTree = leftTree.right;
                leftTree = leftTree.left;
            }
            else {
                numLeaf += (int) Math.pow(2, leftDepth - 1);
                if (rightTree == null) break;
                leftTree = rightTree.left;
                rightTree = rightTree.right;
            }
            leftRightDepth = countDepth(leftTree, false);
            leftDepth--;
        }
        
        return numLeaf;
    }
 ```
