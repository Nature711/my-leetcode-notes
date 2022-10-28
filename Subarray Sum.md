## Basic strategy

- 

## Problems

- [Subarray sum equals K](https://leetcode.com/problems/subarray-sum-equals-k/)

- Brute force (TLE)
```
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int subSum = 0;
                for (int j = i; j < i + len; j++) subSum += nums[j];
                if (subSum == k) count++;
            }
        }
        
        return count;
    }
```

- Sliding window but still TLE
```
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int len = 1; len <= n; len++) {
            int subSum = 0;
            for (int i = 0; i < len; i++) subSum += nums[i];
            if (subSum == k) count++;
            
            for (int i = 1; i <= n - len; i++) {
                subSum = subSum - nums[i - 1] + nums[i + len - 1];
                if (subSum == k) count++;
            }
        }
        
        return count;
    }
```

- [HashMap of prefix sum](https://www.youtube.com/watch?v=HbbYPQc-Oo4&t=3s)
```
public int subarraySum(int[] nums, int k) {
        int count = 0;
        int cumuSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            cumuSum += nums[i];
            if (map.containsKey(cumuSum - k)) {
                count += map.get(cumuSum - k);
            }
            map.put(cumuSum, map.getOrDefault(cumuSum, 0) + 1);
        }
        
        return count;
    }
```

- [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
- Greedy approach
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
