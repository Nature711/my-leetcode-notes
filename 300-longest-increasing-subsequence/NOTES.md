## DP
- dp[i]: length of LIS ending at i (i is included)
- at every index, the number itself can form a subsequence of length 1; or it can be combined with previous subsequences to form a longer subsequence; 
- consider every possible contatenation of the current number with the previous subsequence; choose the one that produces the longest result 
- time: O(n^2)
```
   public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            
            dp[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            
        }
        
        int res = 0;
        for (int num: dp) res = Math.max(res, num);
        return res;
    }
```

## Binary Search
- tails[i] = smallest tail of the subsequence of length i + 1
- tails is an increasing array
- for each number x, we can: 
  (1) if x is larger than all tails, append it, increase the size by 1
  (2) if tails[i-1] < x <= tails[i], update tails[i]
```
public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
        int i = 0, j = size;
        while (i != j) {
            int m = (i + j) / 2;
            if (tails[m] < x)
                i = m + 1;
            else
                j = m;
        }
        tails[i] = x;
        if (i == size) ++size;
    }
    return size;
}
```
