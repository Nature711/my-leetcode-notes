## Idea
- to find two subsets with equal sum --> to find A subset whose sum equals ```total_sum / 2``` 
  -> our goal now is to find if there's a subset with target sum = total_sum / 2
- for any array element ```a[i]```, we have 2 choices: 
  - either choose it --> target = target - a[i]
  - or not choose it --> target = target

## Brute force
![image](https://user-images.githubusercontent.com/77217430/209417358-57095111-b012-4eb7-a3c8-55578216dae3.png)
```
int[] arr;
int n;
public boolean canPartition(int[] nums) {
    arr = nums;
    n = nums.length;
    int sum = 0;
    for (int num: nums) sum += num;
    if (sum % 2 == 1) return false;
    int target = sum / 2;

    return helper(0, target);
}

public boolean helper(int idx, int target) {
    if (idx == n || target < 0) return false;
    if (target == 0) return true;
    return helper(idx + 1, target) || helper(idx + 1, target - arr[idx]);
}
```

- observation: a lot of repeated work --> think of memoization

## Top down DP
```
 public boolean canPartition(int[] nums) {
      int n = nums.length;
      int sum = 0;
      for (int num: nums) sum += num;
      if (sum % 2 == 1) return false;
      int target = sum / 2;

      boolean[][] dp = new boolean[n + 1][target + 1]; 
      //dp[i][j] = whether we can form a subset sum of j using elements from 0...i
      for (int i = 0; i <= target; i++) dp[0][i] = false;
      for (int i = 0; i <= n; i++) dp[i][0] = true;

      for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= target; j++) {
              int rem = j - nums[i - 1];
              dp[i][j] = dp[i - 1][j] || (rem < 0 ? false : dp[i - 1][rem]);

          }
      }
      return dp[n][target];
  }
```
