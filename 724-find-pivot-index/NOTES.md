## Implementation
```
 public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSums = new int[n + 1];
        prefixSums[0] = 0;
        for (int i = 1; i < n + 1; i++) prefixSums[i] = prefixSums[i - 1] + nums[i - 1]; 
 
        for (int i = 0; i < n; i++) {
            int leftSum = prefixSums[i] - prefixSums[0];
            int rightSum = prefixSums[n] - prefixSums[i + 1];
            if (leftSum == rightSum) return i;
        }
        
        return -1;
    }
```

### How edge cases are resolved
- question: The pivot index is the index where the sum of all the numbers **strictly to the left of the index** is equal to the sum of all the numbers **strictly to the index's right**
![image](https://user-images.githubusercontent.com/77217430/204070044-215b0fae-2f39-42b6-87d8-74c9dd8a96b6.png)
