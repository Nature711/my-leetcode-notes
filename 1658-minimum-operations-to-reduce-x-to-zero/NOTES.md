## Hashmap
- similar idea as [subarray sum equals k](https://github.com/Nature711/my-leetcode-notes/blob/master/0560-subarray-sum-equals-k/NOTES.md)
- use a hashmap to store the prefix sum for each index
- keep track of the index of each prefix sum
- for each prefix sum from left, find if there's a prefix sum from right that produces the target
- can stop immediately after we find one
- edge case: the optimal solution occurs on one side (only using elements from left / right) -- we need to check at last and compare the number of operations required with the existing ones we found (if any)

```
public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Integer, Integer> forward_sum_map = new HashMap<>();
        HashMap<Integer, Integer> backward_sum_map = new HashMap<>();
        int forward_sum = 0;
        int backward_sum = 0;
        
        for (int i = 0; i < n; i++) {
            forward_sum += nums[i];
            forward_sum_map.put(forward_sum, i + 1);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            backward_sum += nums[i];
            backward_sum_map.put(backward_sum, nums.length - i);
        }
        
        int minOp = n + 1;
        
        for (int f_sum: forward_sum_map.keySet()) {
            if (backward_sum_map.containsKey(x - f_sum)) {
                int op = forward_sum_map.get(f_sum) + backward_sum_map.get(x- f_sum);
                minOp = Math.min(minOp, op);   
                break;
            } 
        }
        
        for (int b_sum: backward_sum_map.keySet()) {
            if (forward_sum_map.containsKey(x - b_sum)) {
                int op = forward_sum_map.get(x - b_sum) + backward_sum_map.get(b_sum);
                minOp = Math.min(minOp, op);  
                break;
            } 
        }
        
        if (forward_sum_map.containsKey(x)) minOp = Math.min(minOp, forward_sum_map.get(x));
        
        if (backward_sum_map.containsKey(x)) minOp = Math.min(minOp, backward_sum_map.get(x));
        
        return minOp <= n ? minOp : -1;
        
    }
 ```
 
 
 ## Greedy approach
 - at every step, try to pick the bigger element from left / right side of the array
   - intuition behind: we can sum up to target more quickly (i.e., using less no. of operations) by picking the bigger element every time
 - why is this going to work?
   - proof by contradiction, i.e., is there a case when we pick a bigger element at a step but requires more operations in total?
   - no! since all elements are positive, the cumulative sum only increases as we pick more elements 
   - local optimal choice (i.e., picking the bigger element at each step) will always lead to global optimal
   - wait but... what if a big element is "hidden behind" a small element from one side? 
 e.g., [7, 3, 1, 9, 2], target = 11
   - always picking the bigger element:
     - step 1: pick 7 from left since 7 > 2, new target = 4
     - step 2: pick 3 from left since 3 > 2, new target = 1
     - step 3: pick 1 from left since 2 > target, new target = 0 
     - end: 3 operations in total
   - optimal solution: picking the rightmost 2 elements --> 2 operations in total

 
 
 ## Problem reduction to [Maximum size subarray equals k](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)
 
 - find the shortest subarray from left and right that sums up to target <--> find the longest subarray that sums up to (totalSum - target)

```
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (sum - x == 0) return nums.length;
        int max = maxSubArrayLen(nums, sum - x);
        return max == -1 ? max : nums.length - max;
    }
    
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cumuSum = 0;
        int maxLen = 0;
        map.put(0, 0);
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            cumuSum += nums[i];
            if (map.containsKey(cumuSum - k)) {
                found = true;
                maxLen = Math.max(maxLen, i + 1 - map.get(cumuSum - k));
            }
            if (!map.containsKey(cumuSum)) map.put(cumuSum, i + 1);
        }
        return found ? maxLen : -1;
    }
```
