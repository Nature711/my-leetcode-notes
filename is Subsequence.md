# Is Subsequence

## Link
- [Question](https://leetcode.com/problems/is-subsequence/)

## Solutions
### DP
- A bit overkill but still accepted :P
- Time complexity: O(m * n), where m, n are the lengths of each string
```
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m == 0) return true;
        if (n == 0) return false;
        
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = s.charAt(0) == t.charAt(0);
        for (int i = 1; i < n; i++) {
            dp[0][i] = s.charAt(0) == t.charAt(i) || dp[0][i - 1];
        }
       
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) continue;
                dp[i][j] = s.charAt(i) == t.charAt(j) ? dp[i - 1][j - 1] : dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
```

### Two pointers
- Time complexity: O(max(m, n))
```
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m == 0) return true;
        if (n == 0) return false;
        
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            if (s.charAt(i) == t.charAt(j)) i++;
            if (i == m) return true;
        } 
        return false;
    }
```

