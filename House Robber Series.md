## Intro
### Overview
- Find the max amount of money you can rob without alerting police
- Each variation has a slightly different arrangement of houses
- Constraint: can't rob tow adjacent houses

### Topics covered
- DP
- Tree
- DFS

## House Robber I
- Houses arranged in a straight line [1 2 3 4 5]
```
 public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int[] dp = new int[n]; //dp[i] = max amount you can rob from houses {0, ...i}
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], //rob the current house i
                            dp[i - 1]); //don't rob the current house
        }
        
        return dp[n - 1];
    }
```

## House Robber II 
- Houses arragned in a circle [1 2 3 4 5 1]
- Problem reduction: Since House[1] and House[n] are adjacent, they cannot be robbed together. Therefore, the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n], depending on which choice offers more money
```
 public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        // if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int n = nums.length;
        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];
        
        for (int i = 0; i < n - 1; i++) {
            nums1[i] = nums[i];
        }
        
        for (int i = 0; i < n - 1; i++) {
            nums2[i] = nums[i + 1];
        }
        
        return Math.max(robHelper(nums1), robHelper(nums2));
    }
  //robHelper is the same as the rob function in Q1
```

## House Robber III
- Houses arranged in tree structure
### Wrong attempt
```
public int rob(TreeNode root) {
        return Math.max(dfs(root), dfs(root.left) + dfs(root.right));
    }
    
    public int dfs(TreeNode entry) {
        if (entry == null) return 0;
        
        int amount = entry.val;
        
        if (entry.left != null) amount += dfs(entry.left.left) + dfs(entry.left.right);
        if (entry.right != null) amount += dfs(entry.right.left) + dfs(entry.right.right);
        
        return amount;
    }
```
- failed testcase
```
             4
            /
           1
          /
         2
        /
       3
```
- expected: 4 + 3 = 7
- actual: 4 + 2 = 6 
- reason: only doing dp logic at the top level 
- fix: need to implement dp logic at every level

### Correct but TLE
```
  public int rob(TreeNode root) {
        return dfs(root);
    }
    
    public int dfs(TreeNode entry) {
        if (entry == null) return 0;
        
        int amountIfTake = entry.val;
        int amountIfNotTake = 0;
        
        if (entry.left != null) amountIfTake += dfs(entry.left.left) + dfs(entry.left.right);
        if (entry.right != null) amountIfTake += dfs(entry.right.left) + dfs(entry.right.right);
        
        amountIfNotTake += dfs(entry.left) + dfs(entry.right);
        
        return Math.max(amountIfTake, amountIfNotTake);
    }
```

### Corrrect (using memo)
```
 HashMap<TreeNode, Integer> memo = new HashMap<>();
    
    public int rob(TreeNode root) {
        return dfs(root);
    }
    
    public int dfs(TreeNode entry) {
        if (entry == null) return 0;
        
        if (memo.containsKey(entry)) return memo.get(entry);
        
        int amountIfTake = entry.val;
        int amountIfNotTake = 0;
        
        if (entry.left != null) amountIfTake += dfs(entry.left.left) + dfs(entry.left.right);
        if (entry.right != null) amountIfTake += dfs(entry.right.left) + dfs(entry.right.right);
        
        amountIfNotTake += dfs(entry.left) + dfs(entry.right);
        
        int result = Math.max(amountIfTake, amountIfNotTake);
        memo.put(entry, result);
        return result;
    }
```
