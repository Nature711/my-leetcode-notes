## Problem
- [Arithmetic Slices](https://leetcode.com/problems/arithmetic-slices/)

## Solution
### Attempt 1
- dp[i][j] = 1 if the subarray [i...j] is arithmetic, 0 otherwise
- tabulation: n * n table where n = nums.length
- answer: total no. of 1s in the table
- base case: dp[i][j] where j - i == 2, i.e., subarray of length 3
- recursive case: dp[i][j] = 1 if both dp[i][j - 1] and dp[i + 1][j] are 1
  - e.g. [1 2 3 4] is arithematic if both [1 2 3] and [2 3 4] are arithmetic
- building up subproblem by increasing the **length of subarray** of consideration
- time: O(n^2)
- space: O(n^2)

```
public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        
        int[][] dp = new int[n][n];
        int count = 0;
        
        for (int i = 0; i < n - 2; i++) {
            boolean isArithematic = nums[i] + nums[i + 2] == 2 * nums[i + 1];
            if (isArithematic) {
                dp[i][i + 2] = 1;
                count++;
            } else {
                dp[i][i + 2] = 0;
            }
        }
        for (int len = 3; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                boolean isNewArithematic = (dp[i][j - 1] == 1 && dp[i + 1][j] == 1);
                
                if (isNewArithematic) {
                    dp[i][j] = 1;
                    count++;
                } else {
                    dp[i][j] = 0;
                }
            }
        }       
        return count;  
    }
```
## Attempt 2
- dp[i]: no. of arithmetic subarrays ending at index i
- tabulation: array of length n, where n = nums.length
- base case: dp[0] and dp[1] = 0, since the subarray lengths are less than 3
- recursive case: dp[i] = dp[i - 1] + 1 if [i - 2...i] is an arithmetic subarray
  - e.g. [1 2 3 4]
    - when we try to fill in dp[3] (determining how many subarrays ending at index 3)
    - we already have dp[2] == 1 (subproblem)
    - then by realizing nums[1...3] forms an arithmetic subarray, we can extend the subproblem (dp[2]) by 1
    - thus dp[3] = dp[2] + 1
- time: O(n)
- space: O(n)
  - can be optimized to O(1) since each problem dp[i] only depends on exactly 1 subproblem (dp[i - 1])
 
```
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        
        int[] dp = new int[n];
        
        for (int i = 2; i < n; i++) {
            boolean isArithmetic = nums[i] + nums[i - 2] == 2 * nums[i - 1];
            dp[i] = isArithmetic ? dp[i - 1] + 1 : 0;
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) count += dp[i];
        
        return count;
    }
```
