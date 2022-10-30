## Sliding window

- point to note: all array elements are positive --> prefix sum is strictly increasing
- goal: to find the minimum size subarray with sum >= target
- idea: use two pointers to keep a window
  - try to expand the window to the right to get a greater sum until we reach target
  - once we reach target (may exceed), try to shrink window size from left until we drop below target, then try to expand window to the right again 
  - keep sliding window until we reach end of array
- use prefix sum to efficiently compute subarray sum 

```
  public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        
        int[] prefixSums = new int[n + 1];
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            prefixSums[i + 1] = prefixSum;
        }
        
        int low = 0, high = 0, minLen = n + 1;
        
        while (low <= n && high <= n) {
            while (high <= n && prefixSums[high] - prefixSums[low] < target) high++;
            minLen = Math.min(minLen, high - low);
            low++;
        }
            
        return minLen > n ? 0 : minLen;
    }
```
