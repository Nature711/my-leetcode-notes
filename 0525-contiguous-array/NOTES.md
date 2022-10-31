## HashMap + Prefix Sum

- Current problem: Given a binary array, find the maximum length of a contiguous subarray with an equal number of 0 and 1
  - subarray with equal number of 0 and 1 --> 0 & 1 "neutralize" each other out
  - change 0 to -1 --> subarray with equal number of 0 and 1 --> produces a subarray sum of 0
- Problem reduction: after modifying the original array, find the max length of subarray with subarray sum of 0 
  -> reduction to "maximumn subarray that sums to target", with target = 0

```
public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = nums[i] == 0 ? -1 : nums[i];
        
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        int currSum = 0, maxLen = 0;
        prefixSums.put(0, 0);

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            if (prefixSums.containsKey(currSum)) maxLen = Math.max(maxLen, i + 1 - prefixSums.get(currSum));
            else prefixSums.put(currSum, i + 1);
        }
        
        return maxLen;
    }
```
