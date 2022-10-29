## DP & Greedy approach

- [Kadane's algo](https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm)
- sum(0,i) = max sum of suarray ending at i (must include i)
- now the sub problem's format is less flexible, but now the connect between the sub problem & the original one becomes clearer
- To calculate sum(0,i), you have 2 choices: 
  - either adding sum(0,i-1) to a[i], or not. 
  - If sum(0,i-1) is negative, adding it to a[i] will only make a smaller sum, so we throw it away; we add only if it's non-negative.
 
```
 public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; //max sum of subarray ending at i 
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
```

## Divide & Conquer
- divide
- conquer
- merge
