## Recursion (TLE)
```
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(cost, 0, cost.length - 1), helper(cost, 1, cost.length - 1));
    }
    public int helper(int[] cost, int low, int high) {
        if (low == high) return cost[low];
        if (low > high) return 0;
        return cost[low] + Math.min(helper(cost, low + 1, high), helper(cost, low + 2, high));
    }
```

## DP
```
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n]; 
        dp[n - 1] = cost[n - 1];
        dp[n - 2] = cost[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
```
