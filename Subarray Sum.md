## General approaches

### Find subarray sum from prefix sum
- sum of subarray [i...j] = sum of subarray[0...j] - sum of subarray[0...i - 1]
- e.g.
```
i          0  1   2  3  4
arr       [1, 3, -2, 4, 1]
prefixSum  1  4   2  6  7

--> sum of subarray[1...3] (i.e., subarray [3, -2, 4]) = prefixSum[3] - prefixSum[0] = 6 - 1 = 5
--> initialization: prefixSums.put(0, 0) 
--> after computing a subarray sum: prefixSums.put(currSum, currIdx + 1) //offset by 1
```
- if we want to find a subarray that sums up to target k, then at the current subarray sum, we try to look for if there's a prefix sum of (currSum - k)

## Problems

- Subarray sum equals K
    - goal: determine the number of subarrays that sums up to k (regardless of subarray size)
    - [problem](https://leetcode.com/problems/subarray-sum-equals-k/)
    - [notes](https://github.com/Nature711/my-leetcode-notes/blob/master/0560-subarray-sum-equals-k/NOTES.md)

- Maximum size subarray sum equals K
    - find the LONGEST subarray that sums up to k
    - [problem](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)
    - [notes](https://github.com/Nature711/my-leetcode-notes/edit/master/0325-maximum-size-subarray-sum-equals-k/NOTES.md)

- Maximum subarray
    - [problem](https://leetcode.com/problems/maximum-subarray/)
    - [notes](https://github.com/Nature711/my-leetcode-notes/blob/master/0053-maximum-subarray/NOTES.md)

- Minimum Operations to Reduce X to Zero
    - [problem](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/)
    - [notes](https://github.com/Nature711/my-leetcode-notes/edit/master/1658-minimum-operations-to-reduce-x-to-zero/NOTES.md)

- Contiguous Array
    - [problem](https://leetcode.com/problems/contiguous-array/)
    - [notes](https://github.com/Nature711/my-leetcode-notes/blob/master/0525-contiguous-array/NOTES.md)
