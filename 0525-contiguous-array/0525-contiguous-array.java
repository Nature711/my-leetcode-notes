class Solution {
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
}