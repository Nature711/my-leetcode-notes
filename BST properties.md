## Review: Tree traversal

```
         1
       /   \
      2     3
    /   \
   4     5
```

### Depth First Traversals: 
- Inorder (Left, Root, Right) : 4 2 5 1 3 
- Preorder (Root, Left, Right) : 1 2 4 5 3 
- Postorder (Left, Right, Root) : 4 5 2 3 1

### Breadth-First (i.e., Level Order) Traversal: 1 2 3 4 5 


## Traveral & BST

```

         4
       /   \
      2     5
    /   \
   1     3
```

In the case when the tree is a BST, norder traversal prints the node in ascending order
- Inorder: 1 2 3 4 5
- Preorder: 4 2 1 3 5 
- Postorder: 1 3 2 5 4
- Level-order: 4 2 5 1 3


