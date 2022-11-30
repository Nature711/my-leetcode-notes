## recursive

```
class Solution {
    
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }
    
    public void dfs(Node root) {
        if (root == null) return;
        res.add(root.val);
        for (Node child: root.children) dfs(child);
    }
}
```

## iterative

```
    public List<Integer> preorder(Node root) {
        
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) stack.push(node.children.get(i));
        }
        return res;
    }
```
- goal: root --> left child --> right child 
- idea: if it's the root (of its subtree), then we immediately visit it; otherwise store and visit it later
- trick: iterate the node's children list in the reverse order (i.e., from rightmost to leftmost) -- this makes sure the leftmost child is at the top of stack after the current iteration, and we will visit it immediately and possibly adding new nodes along the way
