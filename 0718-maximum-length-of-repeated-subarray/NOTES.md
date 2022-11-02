## DP

- dp[i][j] = max length of repeated array using nums1[0...i] and nums2[0...j], where nums1[i] == nums2[j] (very important, that's what enables us to extend from the subproblem)
- when we find nums1[3] != nums2[3], then dp[3][3] can't be just looking from the max of dp[i - 1][j] and dp[i][j - 1] since we define dp[i][j] to be the ... with nums1[i] == nums2[j] 
- that's what enables us to extend by 1 when we find nums1[4] == nums2[3], in this case dp[4][3] = dp[3][2] + 1 since we're sure the max length of common subarray stored in dp[3][2] has the property that nums[3] == nums[2]

```
i     0 1 2 3 4 5
nums1 x x x 1 2 3
nums2 x x 1 2 3 3
```

### Common mistake
1. forget about global max
2. subproblem to rely on when current 2 indices are not equal

```
  public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (nums1[i - 1] == nums2[j - 1]) 
                    ? dp[i - 1][j - 1] + 1
                    : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[m][n];
    }
 ```
 
