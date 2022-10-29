## HashMap + Prefix Sum

- instead of keeping track of prefix sum + no of occurences of such sum, we keep track of the EARLIEST index at which it occurs
  - intuition behind: a prefix sum may occur for many times, but we only want the earliest occurence of it since this will produce the longest subarray (if possible)
  - since we iterate the array from start to end, only when we encounter a new prefix sum then we put it into map, since otherwise this means we have an earlier occurence of it which we want to (i.e., don't want to overwrite) 
- initialization: intialize the map with (0,0) -- this means the empty subarray has a prefix sum of 0
  - this is going to be useful when we have a prefix sum exactly equals k -->  (cumuSum - k) will be 0 and we calculate the len of such subarray to be (i + 1 - 0) --> this is a subarray from start to current idx i, which has length (i + 1 - 0) 
 
```
 public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cumuSum = 0;
        int maxLen = 0;
        map.put(0, 0); //initialization
        for (int i = 0; i < nums.length; i++) {
            cumuSum += nums[i];
            if (map.containsKey(cumuSum - k)) maxLen = Math.max(maxLen, i + 1 - map.get(cumuSum - k)); (find a subarray that sums up to target --> update maxLen if possible)
            if (!map.containsKey(cumuSum)) map.put(cumuSum, i + 1); //update only if it's a new prefix sum (otherwise keep the earlier occurence)
        }
        return maxLen;
    }
```
