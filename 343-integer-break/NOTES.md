## Recursion with memo
```
  HashMap<Integer, Integer> memo = new HashMap<>();
    
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        
        int res = 1;
        for (int curr = n - 1; curr > 0; curr--) {
            if (!memo.containsKey(n - curr)) {
                memo.put(n - curr, integerBreak(n - curr));
            }
            res = Math.max(res, Math.max(curr * memo.get(n - curr), curr * (n - curr)));
        }
        return res;
    }
```

## DP
```
    
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        
        dp[1] = 1;
        
        for (int curr = 2; curr <= n; curr++) {
            for (int i = curr - 1; i > 0; i--) {
                dp[curr] = Math.max(dp[curr], Math.max(i * dp[curr - i], i * (curr - i)));
            }
        }
        
        return dp[n];
    }
 ```
