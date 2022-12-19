## Recursive

### Path Sum I
```
public boolean hasPathSum(TreeNode root, int targetSum) {
    return dfs(root, targetSum);
}

public boolean dfs(TreeNode root, int rem) {
    if (root == null) return false;
    if (root.left == null && root.right == null && rem == root.val) return true;
    return dfs(root.left, rem - root.val) || dfs(root.right, rem - root.val);
}
```

### Path Sum II
```
List<List<Integer>> paths = new ArrayList<>();
int target;

public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    target = targetSum;
    dfs(root, targetSum, new ArrayList<>());
    return paths;
}

public void dfs(TreeNode root, int rem, List<Integer> currPath) {
    if (root == null) return;

    currPath.add(root.val);

    if (root.left == null && root.right == null && rem == root.val) {
        paths.add(new ArrayList<>(currPath));
    }

    dfs(root.left, rem - root.val, currPath);
    dfs(root.right, rem - root.val, currPath);

    currPath.remove(currPath.size() - 1);
}
```

### Path Sum III
```
int target, count = 0;  
long currSum = 0;
HashMap<Long, Integer> map = new HashMap<>();

public int pathSum(TreeNode root, int targetSum) {
    target = targetSum;
    map.put(currSum, 1);
    preorder(root);

    return count;
}

public void preorder(TreeNode root) {
    if (root == null) return;
    currSum += root.val;
    if (map.containsKey(currSum - target)) {
        count += map.get(currSum - target);
    }
    map.put(currSum, map.getOrDefault(currSum, 0) + 1);
    preorder(root.left);
    preorder(root.right);
    map.put(currSum, map.get(currSum) - 1);
    currSum -= root.val;
}
```


## Iterative

### Path Sum I
```

    Stack<TreeNode> stack = new Stack<>();
    Set<TreeNode> peeked = new HashSet<>();
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int currSum = 0;
        
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                currSum += curr.val;
                curr = curr.left;
            }
            curr = stack.peek();
            if (!peeked.add(curr)) {
                if (currSum == targetSum && curr.left == null && curr.right == null) return true;
                currSum -= stack.pop().val;
                curr = null;
            } else curr = curr.right;
        }
        
        return false;
    }
```

