## Intro
### Overview
- Find the max amount of money you can rob without alerting police
- Each variation has a slightly differentsetting
### Topics covered
- DP
- Tree
- DFS

## House Robber I
- Houses arranged in a straight line 
- Constraint: can't rob tow adjacent houses
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
- Houses arragned in a circle
- Constraint: can't rob tow adjacent houses
