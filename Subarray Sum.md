## Basic strategy

- 

## Problems

- [Subarray sum equals K](https://leetcode.com/problems/subarray-sum-equals-k/)
- Subarray

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
